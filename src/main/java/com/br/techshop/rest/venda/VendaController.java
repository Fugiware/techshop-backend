package com.br.techshop.rest.venda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping("")
	public List<Venda> getAll() {
		return vendaService.getAll();
	}	
	
	@GetMapping("/{id}")
	public Venda getById(@PathVariable("id") Integer id) {
		return vendaService.getById(id);
	}	
	
	@PostMapping("")
	public Venda saveNew(@RequestBody Venda venda) {
		return vendaService.saveNew(venda);
	}
	
	@PutMapping("/{id}")
	public Venda update(@PathVariable("id") Integer id, @RequestBody Venda venda) {
		return vendaService.update(id, venda);
	}
}
