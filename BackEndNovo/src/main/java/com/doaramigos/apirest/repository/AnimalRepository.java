package com.doaramigos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doaramigos.apirest.entidades.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
