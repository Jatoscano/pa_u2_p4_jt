package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.modelo.Habitacion;
import com.example.demo.uce.edu.repository.modelo.dto.EstudianteDTO;
import com.example.demo.uce.edu.service.EstudianteService;
import com.example.demo.uce.edu.service.HotelService;
import com.example.demo.uce.edu.service.MatriculaService;


@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {

	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private HotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		EstudianteDTO estudianteDTO = new EstudianteDTO();
		List<EstudianteDTO> estudianteDTOs = new ArrayList<>();
		
		List<Habitacion> habitaciones = new ArrayList<>();
		
		estudianteDTO.setApellido("Toscano");
		estudianteDTO.setNombre("Juan");
		
		//Estudiante
		//System.out.println(this.estudianteService.buscarTodosDTO("Juan", "Toscano"));
		
		//Matricula
		//System.out.println(this.matriculaService.buscarTodoDTO("Andres", "Prog. Avanzada II"));
		
		//Hotel
		System.out.println(this.hotelService.buscar(4).getNombre());
		
		//Habitacion
		habitaciones = this.hotelService.buscar(4).getHabitaciones();
		
		System.out.println("Habitaciones");
		for (Habitacion e: habitaciones) {
			System.out.println(e.getNumero());
		}
	}
	
}
