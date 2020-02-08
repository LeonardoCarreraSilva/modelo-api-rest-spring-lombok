package com.example.repository;

import com.example.web.domain.models.tb_funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<tb_funcionarios, Integer> {
}
