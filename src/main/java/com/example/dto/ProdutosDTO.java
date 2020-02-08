package com.example.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class ProdutosDTO implements Serializable {
    private int id;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private int forId;
}
