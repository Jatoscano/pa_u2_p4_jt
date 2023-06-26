package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.modelo.Automovil;
import com.example.demo.uce.edu.service.AutomovilService;


@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {

	
	@Autowired
	private AutomovilService automovilService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Automovil automovil = new Automovil();
		List<Automovil> automoviles = new ArrayList<>();
		List<Automovil> automovilesTyped = new ArrayList<>();
		
		automovil.setMarca("Chevrolet");
		automovil.setModelo("Aveo");
		automovil.setAnio(2013);
		automovil.setPrecio(new BigDecimal(18500));
		
		//Query
		// 1 Query SingleResult
		System.out.println(this.automovilService.buscarModelo("Sentra"));
		
		// 1 Query ResultList
		automoviles = this.automovilService.reporteDeAutomoviles("Chevrolet", "Luv-Dimax");
		
		for(Automovil e: automoviles) {
			System.out.println(e);
		}
		
		//TypedQuery
		// 1 TypedQuery SingleResult
		System.out.println(this.automovilService.buscarModeloTyped("Aveo"));
		
		// 1 TypedQuery ResultList
		automovilesTyped = this.automovilService.reportePorAnio(2010);
		
		for(Automovil e: automovilesTyped) {
			System.out.println(e);
		}
		
	   //this.automovilService.registrar(automovil);
		
	}
	
}
