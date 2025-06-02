package com.generation.golady.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	@NotBlank(message = "O atributo 'Categoria' é obrigatório!")
	@Size(min = 4, max = 50, message = "O atributo 'Categoria' deve ter no mínimo 5 e no máximo 50 catacteres!")
	private String categoria;

	@Column(length = 100)
	@NotBlank(message = "O atributo 'Modelo' é obrigatório!")
	@Size(min = 2, max = 100, message = "O atributo 'Modelo' deve ter no mínimo 5 e no máximo 100 catacteres!")
	private String modelo;
	
	@Column(length = 7)
	@NotBlank(message = "O atributo 'Placa' é obrigatório!")
	@Size(min = 7, message = "O atributo 'Placa' deve ter 7 catacteres!")
	private String placa;
	
	@NotNull(message = "O atributo 'Velocidade média' é obrigatório!")
    @DecimalMin(value = "20.00", message = "O atributo 'Velocidade média' deve ter no mínimo o valor 20!")
	private Float velocidadeMedia;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "veiculo", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("veiculo")
	private List<Viagem> viagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Float getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(Float velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	public List<Viagem> getViagem() {
		return viagem;
	}

	public void setViagem(List<Viagem> viagem) {
		this.viagem = viagem;
	}
}
