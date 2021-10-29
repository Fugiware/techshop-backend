package com.br.techshop.rest.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("")
	public List<Estado> getAll() {
		return estadoService.getAll();
	}	
	
	@GetMapping("/{id}")
	public Estado getById(@PathVariable("id") Integer id) {
		return estadoService.getById(id);
	}	
	/* não é utilizado
	@PostMapping("")
	public Estado saveNew(@RequestBody Estado estado) {
		return estadoService.saveNew(estado);
	}
	
	@PutMapping("/{id}")
	public Estado update(@PathVariable("id") Integer id, @RequestBody Estado estado) {
		return estadoService.update(id, estado);
	}
	*/
}
