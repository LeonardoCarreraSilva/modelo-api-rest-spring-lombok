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
import com.example.web.domain.models.tb_clientes;

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
	public tb_clientes create(@RequestBody tb_clientes tbclientes) {
		return clienteRepository.save(tbclientes);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody tb_clientes tbclientes) {
		return clienteRepository.findById(id).map(record ->{
			record.setNome(tbclientes.getNome());
			record.setRg(tbclientes.getRg());
			record.setCpf(tbclientes.getCpf());
			record.setEmail(tbclientes.getEmail());
			record.setTelefone(tbclientes.getTelefone());
			record.setCelular(tbclientes.getCelular());
			record.setCep(tbclientes.getCep());
			record.setEndereco(tbclientes.getEndereco());
			record.setNumero(tbclientes.getNumero());
			record.setComplemento(tbclientes.getComplemento());
			record.setBairro(tbclientes.getBairro());
			record.setCidade(tbclientes.getCidade());
			record.setEstado(tbclientes.getEstado());
			tb_clientes upDated = clienteRepository.save(record);
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
