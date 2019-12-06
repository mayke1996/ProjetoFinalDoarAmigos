package com.doaramigos.apirest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doaramigos.apirest.entidades.Usuario;
import com.doaramigos.apirest.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

//
	// Método para criar novo usuario
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public Usuario addUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

//
//	// Método para buscar usuario por id
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> findUsuarioById(@PathVariable(value = "id") long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent())
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Método para listar todos os usuarios
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

}
