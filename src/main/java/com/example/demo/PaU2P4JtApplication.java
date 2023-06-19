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
		Ciudadano ciudadano2 = new Ciudadano();
		
		//Ciudadano
		ciudadano.setApellido("Toscano");
		ciudadano.setNombre("Juan");
		ciudadano.setCedula("1724693740");
		
		ciudadano2.setApellido("Lucero");
		ciudadano2.setNombre("Andres");
		ciudadano2.setCedula("1724693741");
	
		//Empleado
		empleado.setCargo("Coordinador");
		empleado.setSueldo(new BigDecimal(400));
		
	    //CRUD
		
	    //Ciudadano
	    //ciudadano.setEmpleado(empleado);
	    //this.ciudadanoService.registrar(ciudadano);
	    //this.ciudadanoService.guardar(ciudadano);
	    //this.ciudadanoService.buscar(1);
	    //this.ciudadanoService.borrar(1);
		
	    //Empleado
	    empleado.setCiudadano(ciudadano2);
	    this.empleadoService.registrar(empleado);
	    //this.empleadoService.guardar(empleado);
	    //this.empleadoService.buscar(1);
	    //this.empleadoService.borrar(1);
	    
	}
	
}
