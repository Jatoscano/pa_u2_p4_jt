package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.modelo.CuentaBancaria;
import com.example.demo.uce.edu.service.CuentaBancariaService;


@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {
	
	@Autowired
	private CuentaBancariaService cuentaBancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Creacion de la Cuenta Bancaria - Saldo inicial = 0 
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		cuentaBancaria.setCedulaDePropietario("1724693740");
		cuentaBancaria.setNumero("102938");
		cuentaBancaria.setFechaDeApertura(LocalDateTime.now());
		cuentaBancaria.setSaldo(new BigDecimal(0));
		cuentaBancaria.setTipo("A");
		
		
		CuentaBancaria cuentaBancaria2 = new CuentaBancaria();
		cuentaBancaria2.setCedulaDePropietario("1724693754");
		cuentaBancaria2.setNumero("12345");
		cuentaBancaria2.setFechaDeApertura(LocalDateTime.of(2023, 06, 15, 06, 10));
		cuentaBancaria2.setSaldo(new BigDecimal(0));
		cuentaBancaria2.setTipo("C");
		
		//Inicio de deposito y apertura de la cuenta
		//this.cuentaBancariaService.aperturar(cuentaBancaria2);
		//this.cuentaBancariaService.depositar(3, new BigDecimal(100));
		this.cuentaBancariaService.guardar(cuentaBancaria2);
		//this.cuentaBancariaService.borrar(3);
	}
	
	

}
