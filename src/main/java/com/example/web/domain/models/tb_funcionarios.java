package com.example.web.domain.models;

import lombok.Builder;
import lombok.Data;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
@Data
@Builder
@Entity
@Table(name = "tb_funcionarios")
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
    @Column(name = "senha")
    private String senha;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "nivel_acesso")
    private String nivel_acesso;
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
