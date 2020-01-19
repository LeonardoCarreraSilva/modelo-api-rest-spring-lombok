package com.example.web.controller;

import java.util.List;

import com.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ClienteDTO;
import com.example.service.UsuarioService;
import com.example.web.domain.models.Cliente;

import antlr.collections.impl.LList;
import ch.qos.logback.core.net.server.Client;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RequestMapping("/usuarios")
@RestController
public class ClienteController {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO dto) {
		Cliente cliente = usuarioService.salvar(dto.transformaParaObjeto());
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}

	@GetMapping
	ResponseEntity<Cliente> get(){
		List<Cliente> cliente = usuarioService.getAllUsuario();
		return new ResponseEntity<OK>(cliente, HttpStatus.OK);
	}

	
}
