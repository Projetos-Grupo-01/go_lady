package com.generation.golady.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	@NotBlank(message = "O atributo 'Categoria' é obrigatório!")
	@Size(min = 5, max = 50, message = "O atributo 'Categoria' deve ter no mínimo 5 e no máximo 50 catacteres!")
	private String categoria;

	@Column(length = 100)
	@NotBlank(message = "O atributo 'Modelo' é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo 'Modelo' deve ter no mínimo 5 e no máximo 100 catacteres!")
	private String modelo;
	
	@Column(length = 7)
	@NotBlank(message = "O atributo 'Placa' é obrigatório!")
	@Size(min = 7, message = "O atributo 'Placa' deve ter 7 catacteres!")
	private String placa;
	
	@Digits(integer = 3, fraction = 2, message = "O atributo 'preço' pode ter no máximo 3 digitos inteiros!")
	private float velocidadeMedia;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public float getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(float velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
}
