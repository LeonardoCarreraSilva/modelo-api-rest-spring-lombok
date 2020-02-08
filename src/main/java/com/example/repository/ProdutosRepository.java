package com.example.repository;

import com.example.web.domain.models.tb_produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<tb_produtos, Integer> {
}
