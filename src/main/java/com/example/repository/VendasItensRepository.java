package com.example.repository;

import com.example.web.domain.models.tb_itensvendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasItensRepository extends JpaRepository<tb_itensvendas, Integer> {
}
