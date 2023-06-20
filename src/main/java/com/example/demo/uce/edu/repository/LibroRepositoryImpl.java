package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements LibroRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro libro) {
		
		this.entityManager.persist(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		this.entityManager.merge(libro);
		
	}

	@Override
	public Libro seleccionar(Integer id) {
		
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

}
