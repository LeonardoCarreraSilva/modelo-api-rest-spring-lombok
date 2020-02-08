package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.domain.models.tb_clientes;

@Repository
public interface ClienteRepository extends JpaRepository<tb_clientes, Integer>{

}
