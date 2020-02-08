package com.example.dto;

import com.example.web.domain.models.tb_clientes;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClienteDTO {

	private String nome;
	private String rg;
	private String cpf;
	private String email;
	private String telefone;
	private String cep;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	
	public tb_clientes transformaParaObjeto() {
		return new tb_clientes(nome, rg, cpf, email, telefone, cep, endereco, numero, complemento, bairro, cidade, estado);
	}
}
