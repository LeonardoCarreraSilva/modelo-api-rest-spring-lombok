package com.example.web.domain.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_fornecedores")
public class tb_fornecedores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(max = 100)
    private String nome;
    @Size(max = 16)
    private String cnpj;
    @Size(max = 200)
    private String email;
    @Size(max = 30)
    private String telefone;
    @Size(max = 30)
    private String celular;
    @Size(max = 255)
    private String endereco;

    private int numero;
    @Size(max = 200)
    private String complemento;
    @Size(max = 100)
    private String bairro;
    @Size(max = 100)
    private String cidade;
    @Size(max = 2)
    private String estado;
}
