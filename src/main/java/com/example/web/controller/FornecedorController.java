package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.FornecedorRepository;
import com.example.web.domain.models.Fornecedor;

@RequestMapping("/fornecedor")
@RestController
public class FornecedorController {
	@Autowired
	private FornecedorRepository repository;

	/*-----------------------------------------------------------------------*/
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Fornecedor create(@RequestBody Fornecedor fornecedor) {
		return repository.save(fornecedor);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody Fornecedor fornecedor) {
		return repository.findById(id).map(record -> {
			record.setNome(fornecedor.getNome());
			record.setCnpj(fornecedor.getCnpj());
			record.setEmail(fornecedor.getEmail());
			record.setTelefone(fornecedor.getTelefone());
			record.setCelular(fornecedor.getCelular());
			record.setCep(fornecedor.getCep());
			record.setEndereco(fornecedor.getEndereco());
			record.setNumero(fornecedor.getNumero());
			record.setComplemento(fornecedor.getComplemento());
			record.setBairro(fornecedor.getBairro());
			record.setCidade(fornecedor.getCidade());
			record.setEstado(fornecedor.getEstado());
			Fornecedor upDated = repository.save(record);
			return ResponseEntity.ok().body(upDated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
