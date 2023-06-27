package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.modelo.Estudiante;

public interface EstudianteRepository {

	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
    public Estudiante seleccionar(String cedula);
	public void eliminar(String cedula);
	
	public Estudiante seleccionarPorApellido(String apellido);
	public Estudiante seleccionarPorApellidoTyped(String apellido);
	public Estudiante seleccionarPorApellidoYNombre(String apellido, String nombre);
	public List<Estudiante> seleccionarListaPorApellido(String apellido);
	
	public Estudiante buscaPorApellido(String apellido);
}
