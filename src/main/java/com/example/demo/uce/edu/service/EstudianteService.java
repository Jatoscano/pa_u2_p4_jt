package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.modelo.Estudiante;

public interface EstudianteService {

	public void registrar(Estudiante estudiante);
	public void guardar(Estudiante estudiante);
    public Estudiante buscar(String cedula);
	public void borrar(String cedula);
	
	//Query - Typed Query
	public Estudiante buscarPorApellido(String apellido);
	public Estudiante buscarPorApellidoYNombre(String apellido, String nombre);
	public List<Estudiante> reporteDeEstudiantes(String apellido);
	
	public Estudiante buscarPorApellidoTyped(String apellido);
	
	//NamedQuery
	public Estudiante buscaPorApellidos(String apellido);
	
	public Estudiante buscaPorApellidosNamedQuery(String apellido);
	public Estudiante buscarPorNombreNamedQuery(String nombre);
	
	//NativeQuery
	public Estudiante buscarPorApellidoNativeQuery(String apellido);
	public Estudiante buscarPorApellidoNativeQueryNamed(String apellido);
	public Estudiante buscarPorNombreNativeQueryNamed(String nombre);
	
	//Criteria API Query
	public Estudiante buscarPorApellidoCriteriaAPIQuery(String apellido);
}
