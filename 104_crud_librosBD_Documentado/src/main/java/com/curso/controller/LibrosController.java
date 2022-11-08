package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Libro;
import com.curso.service.LibroService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class LibrosController {
	@Autowired
	LibroService service;
	
	@ApiOperation(value="Devuelve la busqueda de un libro por su isbn en formato json")
	@GetMapping(value="libro/{isbn}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Libro buscarLibro(@ApiParam(value="isbn del libro a buscar") @PathVariable("isbn")int isbn) {
		return service.buscarLibro(isbn);
	}
	@ApiOperation(value="Devuelve la lista con todos los libros en formato json")
	@GetMapping(value="libros",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Libro>libros(){
		return service.libros();
	}
	@ApiOperation(value="Dar de alta un libro")
	@PostMapping(value="libro",consumes=MediaType.APPLICATION_JSON_VALUE)
	void altaLibro(@RequestBody Libro libro) {
		service.altaLibro(libro);
	}
	@ApiOperation(value="Actualizar los datos de un libro")
	@PutMapping(value="libro",consumes=MediaType.APPLICATION_JSON_VALUE)
	void actuLibro(@RequestBody Libro libro) {
		service.actualizarLibro(libro);
	}
	@ApiOperation(value="Eliminar los datos de un libro mediante el isbn especificado")
	@DeleteMapping(value="libro/{isbn}",produces=MediaType.APPLICATION_JSON_VALUE)
	void eliminarLibro(@ApiParam(value="isbn del libro a eliminar")@PathVariable("isbn") int isbn){
		 service.eliminarLibro(isbn);
	}
}
