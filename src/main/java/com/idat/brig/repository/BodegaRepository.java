package com.idat.brig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.brig.modelo.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

}
