package com.es.zgz.app.microservicios.services;

import java.util.Optional;

import com.es.zgz.app.microservicios.models.entity.Polizas;

public interface PolizaService {
	
	public Iterable<Polizas> findAll();
	
	public Optional<Polizas> findById(Long id);
	
	public Polizas save(Polizas poliza);
	
	public void deleteById(Long id);

}
