package com.br.techshop.rest.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Usuario { 
	//CLASSE PRECISA SER IMPLEMENTADA AINDA
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
}
