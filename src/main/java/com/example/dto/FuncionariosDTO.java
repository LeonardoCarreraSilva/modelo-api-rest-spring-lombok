package com.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@Builder
public class FuncionariosDTO implements Serializable {

    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String senha;
    private String cargo;
    private String nivel_acesso;
    private String telefone;
    private String celular;
    private String cep;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
