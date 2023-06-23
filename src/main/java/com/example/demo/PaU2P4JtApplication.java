package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.modelo.Alumno;
import com.example.demo.uce.edu.repository.modelo.Materia;
import com.example.demo.uce.edu.repository.modelo.Matricula;
import com.example.demo.uce.edu.service.MatriculaService;

@SpringBootApplication
public class PaU2P4JtApplication implements CommandLineRunner {

	
	@Autowired
	private MatriculaService matriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Matricula> matriculas = new ArrayList<>();
		
		//Objetos -> Alumno - Materia  - Matricula
		Alumno alumno = new Alumno();
		Materia materia = new Materia();
		Matricula matricula = new Matricula();
		
		
		alumno.setNombre("Andres");
		
		materia.setNombre("Prog. Avanzada II");
		
		matricula.setNumeroDeMatricula("00-01");
		matricula.setFechaDeMatricula(LocalDateTime.now());
		matriculas.add(matricula);
		
		alumno.setMatriculas(matriculas);
		materia.setMatriculas(matriculas);
		matricula.setAlumno(alumno);
		matricula.setMateria(materia);
		
		//CRUD
		//this.matriculaService.registrar(matricula);
		this.matriculaService.guardar(matricula);
		this.matriculaService.buscar(1);
		this.matriculaService.borrar(1);
	}
	
}
