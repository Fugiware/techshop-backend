package com.br.techshop.rest.cidade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.techshop.rest.estado.Estado;

interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	
	List<Cidade> findByEstado(Estado estado);
}
