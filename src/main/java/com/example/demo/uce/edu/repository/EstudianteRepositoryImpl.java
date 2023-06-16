package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Estudiante estudiante) {
	
		this.entityManager.persist(estudiante);
		
	}
	@Override
	public void actualizar(Estudiante estudiante) {
		
		this.entityManager.merge(estudiante);
		
	}
	@Override
	public Estudiante seleccionar(String cedula) {
		
		return this.entityManager.find(Estudiante.class, cedula);
		
	}
	@Override
	public void eliminar(String cedula) {
		
		Estudiante estudiante = this.seleccionar(cedula);
		this.entityManager.remove(estudiante);
		
	}
	

	
	
	
}
