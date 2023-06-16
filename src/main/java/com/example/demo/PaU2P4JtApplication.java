package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.uce.edu.repository.modelo.Ciudadano;
import com.example.demo.uce.edu.repository.modelo.Empleado;
import com.example.demo.uce.edu.service.CiudadanoService;
import com.example.demo.uce.edu.service.EmpleadoService;


@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {
	
	@Autowired
	private CiudadanoService ciudadanoService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Empleado empleado = new Empleado();
		Ciudadano ciudadano = new Ciudadano();
		
		ciudadano.setId(1);
		ciudadano.setApellido("Toscano");
		ciudadano.setNombre("Juan");
		ciudadano.setCedula("1724693740");
	
		empleado.setId(1);
		empleado.setCargo("Coordinador");
		empleado.setSueldo(new BigDecimal(400));
		
		ciudadano.setEmpleado(empleado);
	    empleado.setCiudadano(ciudadano);
	    
	    this.ciudadanoService.registrar(ciudadano);
	    this.empleadoService.registrar(empleado);
	    
	}
	
}
