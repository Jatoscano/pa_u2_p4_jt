package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.modelo.Estudiante;

public interface EstudianteService {

	public void registrar(Estudiante estudiante);
	public void guardar(Estudiante estudiante);
    public Estudiante buscar(String cedula);
	public void borrar(String cedula);
	
}
