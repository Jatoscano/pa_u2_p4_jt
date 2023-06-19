package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.uce.edu.repository.modelo.Ciudadano;
import com.example.demo.uce.edu.repository.modelo.Empleado;
import com.example.demo.uce.edu.repository.modelo.Habitacion;
import com.example.demo.uce.edu.repository.modelo.Hotel;
import com.example.demo.uce.edu.service.CiudadanoService;
import com.example.demo.uce.edu.service.EmpleadoService;
import com.example.demo.uce.edu.service.HabitacionService;
import com.example.demo.uce.edu.service.HotelService;


@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {
	/*
	@Autowired
	private CiudadanoService ciudadanoService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	*/
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*
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
	  
	    */
		
		Hotel hotel = new Hotel();
		Habitacion habitacion = new Habitacion();
		List<Habitacion> habitaciones = new ArrayList<>();
		
		//Hotel
		hotel.setNombre("Marriot");
		hotel.setDireccion("Av. Eloy Alfaro");
		
		//Habitacion
		habitacion.setNumero("01");
		habitacion.setValor(new BigDecimal(100));
		habitaciones.add(habitacion);		
		
		//CRUD
		//Hotel
		hotel.setHabitaciones(habitaciones);
		this.hotelService.registar(hotel);
		this.hotelService.guardar(hotel);
		this.hotelService.buscar(1);
		this.hotelService.borrar(1);
		
		//Habitacion
		habitacion.setHotel(hotel);
		this.habitacionService.registar(habitacion);
		
		this.habitacionService.guardar(habitacion);
		this.habitacionService.buscar(1);
		this.habitacionService.borrar(1);
		
	}
	
}
