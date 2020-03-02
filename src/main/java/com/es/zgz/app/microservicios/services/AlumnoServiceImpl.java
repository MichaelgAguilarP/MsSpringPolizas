package com.es.zgz.app.microservicios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.zgz.app.microservicios.models.entity.Polizas;
import com.es.zgz.app.microservicios.models.repository.PolizaRepository;

@Service
public class AlumnoServiceImpl implements PolizaService {
	
	@Autowired
	private PolizaRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Polizas> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Polizas> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Polizas save(Polizas poliza) {
		return repository.save(poliza);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}