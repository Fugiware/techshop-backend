package com.br.techshop.rest.venda;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.br.techshop.rest.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Venda {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime dataVenda;
	private Double valorTotal;
	private double valorDesconto;
	@ManyToOne @JoinColumn(name="usuario_ID", nullable=false)
	private Usuario usuario;
}
