package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		
		//SQL
		//SLEECT * FROM  estudiante e WHERE e.estu_apellido = 
		
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT e FROM Estudiante e WHERE e.apellido =
		
		Query myQuery =  this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante)myQuery.getSingleResult();
	}
	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		
		Query myQuery =  this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		
		return myQuery.getResultList();

	}
	@Override
	public Estudiante seleccionarPorApellidoYNombre(String apellido, String nombre) {
		
		Query myQuery =  this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.nombre = :datoNombre");
		
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		
		return (Estudiante)myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		
		TypedQuery<Estudiante> mQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido"
				, Estudiante.class);
		mQuery.setParameter("datoApellido", apellido);
		
		return mQuery.getSingleResult();
	}
	
	
	
}
