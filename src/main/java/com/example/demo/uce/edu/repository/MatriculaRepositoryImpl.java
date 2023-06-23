package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements MatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Matricula matricula) {
		
		this.entityManager.persist(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		
		this.entityManager.merge(matricula);
	}

	@Override
	public Matricula seleccionar(Integer id) {
		
		return this.entityManager.find(Matricula.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}
	
	

}
