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

import com.generation.golady.model.Viagem;
import com.generation.golady.repository.UsuarioRepository;
import com.generation.golady.repository.VeiculoRepository;
import com.generation.golady.repository.ViagemRepository;
import com.generation.golady.service.ViagemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/viagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ViagemController {

	@Autowired
	private ViagemRepository viagemRepository;

	@Autowired
	private ViagemService viagemService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping
	public ResponseEntity<List<Viagem>> getAll() {
// SELECT * FROM tb_viagens;
		return ResponseEntity.ok(viagemRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Viagem> getById(@PathVariable Long id) {
		return viagemRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/usuario/{nome}")
	public ResponseEntity<List<Viagem>> getAllByTitulo(@PathVariable String nome) {

		return ResponseEntity.ok(viagemRepository.findAllByUsuarioNomeContainingIgnoreCase(nome));

	}

	@PostMapping
	public ResponseEntity<Viagem> post(@Valid @RequestBody Viagem viagem) {
		
		if(usuarioRepository.existsById(viagem.getUsuario().getId())) {
			
			if(veiculoRepository.existsById(viagem.getVeiculo().getId())) {
				viagem.setPreco(viagemService.calculaPreco(viagem.getDistancia()));
				viagem.setHorariodechegada(viagemService.calculaHorarioChegada(viagem.getDistancia()));
				return ResponseEntity.status(HttpStatus.CREATED).body(viagemRepository.save(viagem));
			}
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O veiculo não existe!", null);
		}
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O usuário não existe!", null);

	}

	@PutMapping
	public ResponseEntity<Viagem> put(@Valid @RequestBody Viagem viagem) {

		if (viagem.getId() == null)
			return ResponseEntity.badRequest().build();
		
		if (viagemRepository.existsById(viagem.getId())) {
			viagem.setPreco(viagemService.calculaPreco(viagem.getDistancia()));
			viagem.setHorariodechegada(viagemService.calculaHorarioChegada(viagem.getDistancia()));
			return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.save(viagem));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {

		Optional<Viagem> viagem = viagemRepository.findById(id);

		if (viagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		viagemRepository.deleteById(id);

// DELETE FROM tb_postagens WHERE id=?;
	}
}