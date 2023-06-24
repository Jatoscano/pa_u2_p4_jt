package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.modelo.Estudiante;

public interface EstudianteService {

	public void registrar(Estudiante estudiante);
	public void guardar(Estudiante estudiante);
    public Estudiante buscar(String cedula);
	public void borrar(String cedula);
	
	public Estudiante buscarPorApellido(String apellido);
	public Estudiante buscarPorApellidoYNombre(String apellido, String nombre);
	public List<Estudiante> reporteDeEstudiantes(String apellido);
	
	public Estudiante buscarPorApellidoTyped(String apellido);
}
