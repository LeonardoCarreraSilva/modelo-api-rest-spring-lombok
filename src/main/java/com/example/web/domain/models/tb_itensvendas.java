package com.example.web.domain.models;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "tb_itensvendas")
public class tb_itensvendas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(targetEntity = tb_vendas.class)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private  int vendaId;
    @ManyToOne(targetEntity = tb_produtos.class)
    @JoinColumn(name = "id", insertable =  false, updatable = false)
    private int produtoId;
    @Column(name = "qtd")
    private int qtd;
    @Column(name = "subtotal")
    private BigDecimal subtotal;
}
