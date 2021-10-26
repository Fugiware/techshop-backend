package com.br.techshop.rest.cidade;

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
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("")
	public List<Cidade> getAll() {
		return cidadeService.getAll();
	}	
	
	@GetMapping("/{id}")
	public Cidade getById(@PathVariable("id") Integer id) {
		return cidadeService.getById(id);
	}	
	
	@PostMapping("")
	public Cidade saveNew(@RequestBody Cidade cidade) {
		return cidadeService.saveNew(cidade);
	}
	
	@PutMapping("/{id}")
	public Cidade update(@PathVariable("id") Integer id, @RequestBody Cidade cidade) {
		return cidadeService.update(id, cidade);
	}
}
