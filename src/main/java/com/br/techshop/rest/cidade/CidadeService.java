package com.br.techshop.rest.cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> getAll() {
		return repository.findAll();
	}	
	
	public Cidade getById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Cidade saveNew(Cidade cidade) {
		cidade.setId(null);
		return repository.saveAndFlush(cidade);
	}
	
	public Cidade update(Integer id, Cidade cidade) {
		Cidade old = repository.findById(id).orElse(null);
		if(old == null) {
			return null;
		} else {
			old.setNome(cidade.getNome());
			old.setEstado(cidade.getEstado());
			return repository.saveAndFlush(old);
		}
		
	}
}
