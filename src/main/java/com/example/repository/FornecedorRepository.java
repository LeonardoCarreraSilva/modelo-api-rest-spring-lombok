package com.example.repository;

import com.example.web.domain.models.tb_fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<tb_fornecedores, Integer> {
}
