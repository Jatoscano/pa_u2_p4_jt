package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.modelo.Estudiante;

public interface EstudianteRepository {

	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
    public Estudiante seleccionar(String cedula);
	public void eliminar(String cedula);
	
	//Query - Typed Query
	public Estudiante seleccionarPorApellido(String apellido);
	public Estudiante seleccionarPorApellidoTyped(String apellido);
	public Estudiante seleccionarPorApellidoYNombre(String apellido, String nombre);
	public List<Estudiante> seleccionarListaPorApellido(String apellido);
	
	//NamedQuery
	public Estudiante seleccionarPorApellidos(String apellido);
	public Estudiante seleccionarPorApellidosNamedQuery(String apellido);
	public Estudiante seleccionarPorNombreNamedQuery(String nombre);
	
	//NativeQuery
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido);
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido);
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre);
	
	//Criteria API Query
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido);
}
