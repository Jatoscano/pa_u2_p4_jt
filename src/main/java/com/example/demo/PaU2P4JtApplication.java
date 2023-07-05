package com.example.demo;

import java.math.BigDecimal;
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
		
		Estudiante estudiante = new Estudiante();
		
		estudiante.setApellido("Aviles");
		estudiante.setNombre("Orlando");
		estudiante.setCedula("1728394765");
		estudiante.setEdad("28");
		estudiante.setPeso(100.5);
		
		//CRUD 
		//this.estudianteService.registrar(estudiante);
		
		//Named Query
		//System.out.println(this.estudianteService.buscaPorApellidos("Davila"));
		//System.out.println(this.estudianteService.buscaPorApellidosNamedQuery("Davila"));
		//System.out.println(this.estudianteService.buscarPorNombreNamedQuery("Juan"));
		
		//Native Query
		//System.out.println(this.estudianteService.buscarPorApellidoNativeQuery("Davila"));
		//System.out.println(this.estudianteService.buscarPorApellidoNativeQueryNamed("Davila"));
		//System.out.println(this.estudianteService.buscarPorNombreNativeQueryNamed("Juan"));
		
		//Criteria API Query
		//System.out.println(this.estudianteService.buscarPorApellidoCriteriaAPIQuery("Davila"));
		System.out.println(this.estudianteService.buscarEstudianteDinamico("Orlando", "Aviles", 100.5));
		System.out.println(this.estudianteService.buscarEstudianteDinamico("Fernanda", "Avila", 80.2));
		
		//UPDATE - DELETE
		System.out.println(this.estudianteService.borrarPorNombre("Andres"));
		System.out.println(this.estudianteService.guardararPorApellido("Juan", "Toscano"));
	}
	
}
