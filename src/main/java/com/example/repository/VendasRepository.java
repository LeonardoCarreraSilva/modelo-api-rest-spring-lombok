package com.example.repository;

import com.example.web.domain.models.tb_vendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<tb_vendas,Integer> {
}
