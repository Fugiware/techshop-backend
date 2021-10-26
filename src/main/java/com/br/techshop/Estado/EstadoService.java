package com.br.techshop.Estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> getAll() {
		return repository.findAll();
	}	
	
	public Estado getById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Estado saveNew(Estado estado) {
		estado.setId(null);
		return repository.saveAndFlush(estado);
	}
	
	public Estado update(Integer id, Estado estado) {
		Estado old = repository.findById(id).orElse(null);
		if(old == null) {
			return null;
		} else {
			old.setNome(estado.getNome());
			old.setSigla(estado.getSigla());
			return repository.saveAndFlush(old);
		}
		
	}
}
