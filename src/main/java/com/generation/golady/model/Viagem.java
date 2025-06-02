package com.generation.golady.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_viagem")
public class Viagem {

	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // UTO_INCREMENT
	private Long id;

	@NotNull(message = "Distância Pecorrida!")
	private Float distancia;

	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;

	@UpdateTimestamp
	private LocalDateTime horariodesaida;

	private LocalDateTime horariodechegada;
	
	@ManyToOne
	@JsonIgnoreProperties("viagem")
	private Usuario usuario;

	@ManyToOne
	@JsonIgnoreProperties("viagem")
	private Veiculo veiculo;

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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
