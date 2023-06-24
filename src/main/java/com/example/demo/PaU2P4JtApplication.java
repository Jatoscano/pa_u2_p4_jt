package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

		Estudiante estudiante =  new Estudiante();
		List<Estudiante> estudiantes = new ArrayList<>();
		
		
		estudiante.setApellido("Davila");
		estudiante.setNombre("Andres");
		estudiante.setEdad("26");
		estudiante.setCedula("1724693741");
		
		estudiantes = this.estudianteService.reporteDeEstudiantes("Toscano");
		
		for(Estudiante e: estudiantes) {
			System.out.println(e);
		}
		
		System.out.println(this.estudianteService.buscarPorApellidoYNombre("Toscano", "Andres"));
		
		//this.estudianteService.registrar(estudiante);
		//this.estudianteService.guardar(estudiante);
		//this.estudianteService.buscarPorApellido("Toscano");
		
		System.out.println(this.estudianteService.buscarPorApellidoTyped("Davila"));
		
	}
	
}
