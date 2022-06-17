package com.idat.brig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.brig.modelo.Cliente;

@Repository
public interface ClienteRepositoy extends JpaRepository<Cliente, Integer>{

}
