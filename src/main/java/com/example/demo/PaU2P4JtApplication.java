package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.modelo.Estudiante;
import com.example.demo.uce.edu.service.EstudianteService;

@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estudiante estudiante = new Estudiante();
		estudiante.setApellido("Toscano");
		estudiante.setNombre("Juan");
		estudiante.setEdad("26");
		estudiante.setCedula("1724693740");
		
		estudianteService.registrar(estudiante);
		
	}
	
	

}
