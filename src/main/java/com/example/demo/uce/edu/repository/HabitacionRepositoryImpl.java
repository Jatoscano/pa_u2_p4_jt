package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements HabitacionRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Habitacion habitacion) {
		
		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		
		this.entityManager.merge(habitacion);
	}

	@Override
	public Habitacion seleccionar(Integer id) {
		
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

}
