package com.generation.golady.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.golady.model.Veiculo;
import com.generation.golady.repository.VeiculoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> getAll() {
		return ResponseEntity.ok(veiculoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> getById(@PathVariable Long id) {
		return veiculoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Veiculo>> getAllByCategoria(@PathVariable String categoria) {
		
		return ResponseEntity.ok(veiculoRepository.findAllByCategoriaContainingIgnoreCase(categoria));
		
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> post(@Valid @RequestBody Veiculo veiculo) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoRepository.save(veiculo));
		
	}
	
	@PutMapping
	public ResponseEntity<Veiculo> put(@Valid @RequestBody Veiculo veiculo) { 
		
		if(veiculo.getId() == null)
			return ResponseEntity.badRequest().build();
		
		if(veiculoRepository.existsById(veiculo.getId())) {
			
				return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.save(veiculo));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // sobreescreve o resultado padrão da rota, substituindo o OK por NO_CONTENT
	public void delete(@PathVariable Long id) {
		
		Optional<Veiculo> postagem = veiculoRepository.findById(id);
		
		if(postagem.isEmpty()) // verifica se há uma postagem com o ID informado
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		veiculoRepository.deleteById(id); // DELETE FROM tb_postagens WHERE id = ?;
	}
}
