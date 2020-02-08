package com.example.web.domain.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "tb_vendas")
public class tb_vendas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "cliente_id")
    private int cliente_id;
    @Column(name = "data_venda")
    private Date data_venda;
    @Column(name = "total_venda")
    private BigDecimal total_venda;
    @Column(name = "observacoes")
    private String observacoes;
    @OneToOne(targetEntity = tb_clientes.class)
    @JoinColumn(name = "id")
    private int clienteId;
}
