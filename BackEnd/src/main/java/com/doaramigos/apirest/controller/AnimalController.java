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

import com.doaramigos.apirest.entidades.Animal;
import com.doaramigos.apirest.repository.AnimalRepository;

@RestController
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepository;

	// Método para listar todos os usuarios
	@RequestMapping(value = "/animal", method = RequestMethod.GET)
	public List<Animal> listarAnimais() {
		return animalRepository.findAll();
	}

	// Metodo para busca de Animal
	@RequestMapping(value = "/animal/{id}", method = RequestMethod.GET)
	public ResponseEntity<Animal> findAnimalById(@PathVariable(value = "id") long id) {
		Optional<Animal> animal = animalRepository.findById(id);
		if (animal.isPresent())
			return new ResponseEntity<Animal>(animal.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Método para criar novo animal
	@RequestMapping(value = "/animal", method = RequestMethod.POST)
	public Animal addAnimal(@Valid @RequestBody Animal animal) {
		return animalRepository.save(animal);
	}

}
