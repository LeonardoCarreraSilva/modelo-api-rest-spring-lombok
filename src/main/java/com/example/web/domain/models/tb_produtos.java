package com.example.web.domain.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "tb_produtos")
public class tb_produtos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "descicao")
    private String descricao;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "qtd_estoque")
    private Integer qtd_estoque;
//    @Column(name = "for_id")
    @ManyToOne(targetEntity = tb_fornecedores.class)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private int forId;
}
