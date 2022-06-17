package com.idat.brig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.brig.modelo.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer>{

}
