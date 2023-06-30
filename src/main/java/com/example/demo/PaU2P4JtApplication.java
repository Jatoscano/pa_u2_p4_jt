package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
		
		//Named Query
		//System.out.println(this.estudianteService.buscaPorApellidos("Davila"));
		//System.out.println(this.estudianteService.buscaPorApellidosNamedQuery("Davila"));
		//System.out.println(this.estudianteService.buscarPorNombreNamedQuery("Juan"));
		
		//Native Query
		//System.out.println(this.estudianteService.buscarPorApellidoNativeQuery("Davila"));
		//System.out.println(this.estudianteService.buscarPorApellidoNativeQueryNamed("Davila"));
		//System.out.println(this.estudianteService.buscarPorNombreNativeQueryNamed("Juan"));
		
		//Criteria API Query
		System.out.println(this.estudianteService.buscarPorApellidoCriteriaAPIQuery("Davila"));
	}
	
}
