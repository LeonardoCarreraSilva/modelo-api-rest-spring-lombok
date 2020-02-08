package com.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.io.Serializable;
@Data
@Builder
@ToString
public class FornecedorDTO implements Serializable {

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
    private Integer numero;
    @Size(max = 200)
    private String complemento;
    @Size(max = 100)
    private String bairro;
    @Size(max = 100)
    private String cidade;
    @Size(max = 2)
    private String estado;
}
