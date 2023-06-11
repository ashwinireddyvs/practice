package com.smart4aviation.aeroflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart4aviation.aeroflight.enity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
