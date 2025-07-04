package com.generation.golady.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_viagem")
public class Viagem {

	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Long id;

	@NotNull(message = "Distância Pecorrida!")
	private Float distancia;

	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;
	
	@NotBlank(message = "O Atributo Endereço de Partida é Obrigatório!")
	private String enderecoPartida;
	
	@NotBlank(message = "O Atributo Endereço de Chegada é Obrigatório!")
	private String enderecoChegada;

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

	public String getEnderecoPartida() {
		return enderecoPartida;
	}

	public void setEnderecoPartida(String enderecoPartida) {
		this.enderecoPartida = enderecoPartida;
	}

	public String getEnderecoChegada() {
		return enderecoChegada;
	}

	public void setEnderecoChegada(String enderecoChegada) {
		this.enderecoChegada = enderecoChegada;
	}

}
