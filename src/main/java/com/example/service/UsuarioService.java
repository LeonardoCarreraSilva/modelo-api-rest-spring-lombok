package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.ClienteRepository;
import com.example.web.domain.models.Cliente;

@Service
public class UsuarioService {
	List<Cliente>cliente;
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public UsuarioService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> getAllUsuario(){
		return clienteRepository.findAll();
	}
	
	public Cliente getUsuario(int id) {
		return cliente.get(id);
	}
	
	
	
}
