package com.example.demo;

import java.math.BigDecimal;

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
		
		automovil.setMarca("Mitsubishi");
		automovil.setModelo("Sen");
		automovil.setAnio(1999);
		automovil.setPrecio(new BigDecimal(20500));
		automovil.setPotenciaMotor(1.0);
		
		//CRUD
		//this.automovilService.registrar(automovil);
		
		//Criteria API Query
		System.out.println(this.automovilService.buscarAutomovilDinamico("Audi", "Zero", 3.0));
		System.out.println(this.automovilService.buscarAutomovilDinamico("Mitsubishi", "Sen", 1.0));
	}
	
}
