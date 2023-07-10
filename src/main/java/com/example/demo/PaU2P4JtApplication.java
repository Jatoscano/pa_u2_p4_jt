package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.modelo.Habitacion;
import com.example.demo.uce.edu.repository.modelo.dto.AutomovilDTO;
import com.example.demo.uce.edu.service.AutomovilService;
import com.example.demo.uce.edu.service.HotelService;


@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {
	
	@Autowired
	private AutomovilService automovilService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		AutomovilDTO automovilDTO = new AutomovilDTO();
		
		automovilDTO.setModelo("Supra");
		automovilDTO.setMarca("Toyota");
		automovilDTO.setPrecio(new BigDecimal(8000));
		
		System.out.println(this.automovilService.buscarDTO("Sentra", "Nissna", new BigDecimal(8000)));
	}
	
}
