package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.modelo.Estudiante;

public interface EstudianteRepository {

	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
    public Estudiante seleccionar(String cedula);
	public void eliminar(String cedula);
	
	
}
