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

import com.example.repository.ClienteRepository;
import com.example.web.domain.models.Cliente;

@RequestMapping("/clientes")
@RestController
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;

	/*-----------------------------------------------------------------------*/
	@GetMapping
	public List findAll(){
		return clienteRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		return clienteRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		return clienteRepository.findById(id).map(record ->{
			record.setNome(cliente.getNome());
			record.setRg(cliente.getRg());
			record.setCpf(cliente.getCpf());
			record.setEmail(cliente.getEmail());
			record.setTelefone(cliente.getTelefone());
			record.setCelular(cliente.getCelular());
			record.setCep(cliente.getCep());
			record.setEndereco(cliente.getEndereco());
			record.setNumero(cliente.getNumero());
			record.setComplemento(cliente.getComplemento());
			record.setBairro(cliente.getBairro());
			record.setCidade(cliente.getCidade());
			record.setEstado(cliente.getEstado());
			Cliente upDated = clienteRepository.save(record);
			return ResponseEntity.ok().body(upDated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		return clienteRepository.findById(id)
				.map(record -> {
		               clienteRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

	
}
