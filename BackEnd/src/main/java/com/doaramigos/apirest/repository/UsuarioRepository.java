package com.doaramigos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doaramigos.apirest.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
