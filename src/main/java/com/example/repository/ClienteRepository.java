package com.example.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.web.domain.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
