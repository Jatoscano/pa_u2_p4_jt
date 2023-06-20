package com.example.demo;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.modelo.Autor;
import com.example.demo.uce.edu.repository.modelo.Libro;
import com.example.demo.uce.edu.service.AutorService;


@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {
	
	@Autowired
	private AutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Autor autor = new Autor();
		Libro libro1 = new Libro();
		Libro libro2 = new Libro();
		Set<Autor> autores = new HashSet<>();
		Set<Libro> libros = new HashSet<>();
		
	
		
		autor.setNombre("Andres");
		autor.setApellido("Cortaza");
		
		
		libro1.setTitulo("El viento se lo llevo");
		libro1.setEditorial("Pearson");
		
		libro2.setTitulo("La vida es bella");
		libro2.setEditorial("AYLLA");
		libros.add(libro1);
		libros.add(libro2);
		autores.add(autor);
		//CRUD
		
		//Autor
		autor.setLibros(libros);
		libro1.setAutores(autores);
		libro2.setAutores(autores);
		this.autorService.registrar(autor);
		this.autorService.guardar(autor);
		this.autorService.buscar(1);
		this.autorService.borrar(1);
		
		
	}
	
}
