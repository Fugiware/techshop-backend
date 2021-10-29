package com.br.techshop.rest.venda;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
	@Autowired
	private VendaRepository repository;
	
	public List<Venda> getAll() {
		return repository.findAll();
	}	
	
	public Venda getById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Venda saveNew(Venda venda) {
		venda.setId(null);
		venda.setDataVenda(LocalDateTime.now());
		return repository.saveAndFlush(venda);
	}
	
	public Venda update(Integer id, Venda venda) {
		Venda old = repository.findById(id).orElse(null);
		if(old == null) {
			return null;
		} else {
			old.setValorDesconto(venda.getValorDesconto());
			old.setValorTotal(venda.getValorTotal());
			old.setUsuario(venda.getUsuario());
			return repository.saveAndFlush(old);
		}
	}
}
