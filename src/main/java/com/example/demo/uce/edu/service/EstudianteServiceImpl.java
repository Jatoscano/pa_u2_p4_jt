package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.EstudianteRepository;
import com.example.demo.uce.edu.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public void registrar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public Estudiante buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(cedula);
	}

	//Query
	@Override
	public Estudiante buscarPorApellido(String apellido) {
	
		return this.estudianteRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Estudiante> reporteDeEstudiantes(String apellido) {
		
		return this.estudianteRepository.seleccionarListaPorApellido(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoYNombre(String apellido, String nombre) {
		
		return this.estudianteRepository.seleccionarPorApellidoYNombre(apellido, nombre);
	}

	//Typed Query
	@Override
	public Estudiante buscarPorApellidoTyped(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellidoTyped(apellido);
	}

	//Named Query
	@Override
	public Estudiante buscaPorApellidos(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellidos(apellido);
	}

	@Override
	public Estudiante buscaPorApellidosNamedQuery(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellidosNamedQuery(apellido);
	}
	
	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		
		return this.estudianteRepository.seleccionarPorNombreNamedQuery(nombre);
	}

	//Native Query
	@Override
	public Estudiante buscarPorApellidoNativeQuery(String apellido) {
	
		return this.estudianteRepository.seleccionarPorApellidoNativeQuery(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNativeQueryNamed(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellidoNativeQueryNamed(apellido);
	}

	
	@Override
	public Estudiante buscarPorNombreNativeQueryNamed(String nombre) {
		
		return this.estudianteRepository.seleccionarPorNombreNativeQueryNamed(nombre);
	}
	
	//Criteria API Query
	@Override
	public Estudiante buscarPorApellidoCriteriaAPIQuery(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellidoCriteriaAPIQuery(apellido);
	}

	@Override
	public Estudiante buscarEstudianteDinamico(String nombre, String apellido, Double peso) {
		
		return this.estudianteRepository.seleccionarEstudianteDinamico(nombre, apellido, peso);
	}

	//UPDATE - DELETE
	@Override
	public int borrarPorNombre(String nombre) {
		
		return this.estudianteRepository.elimimarPorNombre(nombre);
	}

	@Override
	public int guardararPorApellido(String nombre, String apellido) {
		
		return this.estudianteRepository.actualizarPorApellido(nombre, apellido);
	}
	
}
