package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		Set<Libro> libros = new HashSet<>();
		
		libros = (Set<Libro>) this.autorService.buscar(2).getLibros();
		
		for(Libro e: libros) {
			System.out.println(e);
		}
	}
	
}
