package com.es.zgz.app.microservicios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.zgz.app.microservicios.models.entity.Polizas;
import com.es.zgz.app.microservicios.services.PolizaService;

@RestController
public class PolizaController {

	@Autowired
	private PolizaService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Polizas> pol = service.findById(id);
		if (pol.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pol.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Polizas poliza) {
		Polizas polizaDb = service.save(poliza);
		return ResponseEntity.status(HttpStatus.CREATED).body(polizaDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Polizas poliza, @PathVariable Long id) {
		Optional<Polizas> pol = service.findById(id);
		if (pol.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Polizas polizaDb = pol.get();
		polizaDb.setNombre(poliza.getNombre());
		polizaDb.setApellido(poliza.getApellido());
		polizaDb.setEmail(poliza.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(polizaDb));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
