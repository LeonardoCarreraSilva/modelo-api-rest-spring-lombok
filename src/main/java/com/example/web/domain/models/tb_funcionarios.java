package com.example.web.domain.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class tb_funcionarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "cep")
    private String cep;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "numero")
    private int numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
}
