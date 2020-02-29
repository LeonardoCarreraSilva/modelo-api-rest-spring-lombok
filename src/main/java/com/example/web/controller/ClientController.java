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

import com.example.repository.ClientRepository;
import com.example.web.domain.models.tb_client;

@RequestMapping("/client")
@RestController
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;

	/*-----------------------------------------------------------------------*/
	@GetMapping
	public List findAll(){
		return clientRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		return clientRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public tb_client create(@RequestBody tb_client tbclientes) {
		return clientRepository.save(tbclientes);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity upDate(@PathVariable("id") Integer id, @RequestBody tb_client tbclientes) {
		return clientRepository.findById(id).map(record ->{
			record.setName(tbclientes.getName());
			record.setSsh(tbclientes.getSsh());
			record.setEmail(tbclientes.getEmail());
			record.setPhone(tbclientes.getPhone());
			record.setCelphone(tbclientes.getCelphone());
			record.setZipcode(tbclientes.getZipcode());
			record.setAddress(tbclientes.getAddress());
			record.setNumber(tbclientes.getNumber());
			record.setComplement(tbclientes.getComplement());
			record.setNeighborhood(tbclientes.getNeighborhood());
			record.setCity(tbclientes.getCity());
			record.setState(tbclientes.getState());
			tb_client upDated = clientRepository.save(record);
			return ResponseEntity.ok().body(upDated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		return clientRepository.findById(id)
				.map(record -> {
		               clientRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

	
}
