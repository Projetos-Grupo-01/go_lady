package com.generation.golady.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_viagem")
public class Viagem {

	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // UTO_INCREMENT
	private Long id;

	@NotBlank(message = "Distância Pecorrida!")
	private Float distancia;

	@NotNull(message = "Preço é obrigatório!")
	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;

	@UpdateTimestamp
	private LocalDateTime horariodesaida;

	@UpdateTimestamp
	private LocalDateTime horariodechegada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getDistancia() {
		return distancia;
	}

	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDateTime getHorariodesaida() {
		return horariodesaida;
	}

	public void setHorariodesaida(LocalDateTime horariodesaida) {
		this.horariodesaida = horariodesaida;
	}

	public LocalDateTime getHorariodechegada() {
		return horariodechegada;
	}

	public void setHorariodechegada(LocalDateTime horariodechegada) {
		this.horariodechegada = horariodechegada;
	}

}
