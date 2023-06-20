package com.example.demo;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.modelo.Autor;
import com.example.demo.uce.edu.repository.modelo.Libro;
import com.example.demo.uce.edu.service.LibroService;


@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {

	
	@Autowired
	private LibroService libroService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Autor autor1 = new Autor();
		Autor autor2 = new Autor();
		Autor autor3 = new Autor();
		Libro libro = new Libro();
		
		Set<Autor> autores = new HashSet<>();
		Set<Libro> libros = new HashSet<>();
		
	
		//Autores
		autor1.setNombre("Andres");
		autor1.setApellido("Cortaza");
		
		
		autor2.setNombre("Daniela");
		autor2.setApellido("Davila");
		
		
		autor3.setNombre("Edauardo");
		autor3.setApellido("Silva");
		
		
		//Libros
		libro.setTitulo("El viento se lo llevo");
		libro.setEditorial("Pearson");
		
		libros.add(libro);
		autores.add(autor1);
		autores.add(autor2);
		autores.add(autor3);
		
		//CRUD
		
		//Libros
		
		libro.setAutores(autores);
		autor1.setLibros(libros);
		autor2.setLibros(libros);
		autor3.setLibros(libros);
		
		this.libroService.registrar(libro);
		this.libroService.guardar(libro);
		this.libroService.buscar(1);
		this.libroService.borrar(1);
		
	}
	
}
