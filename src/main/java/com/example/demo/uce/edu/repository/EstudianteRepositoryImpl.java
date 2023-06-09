package com.example.demo.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Estudiante;

@Repository
public class EstudianteRepositoryImpl implements EstudianteRepository{

	private static List<Estudiante> basDatos = new ArrayList<>(); 
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		basDatos.add(estudiante);
		
	}

	
}
