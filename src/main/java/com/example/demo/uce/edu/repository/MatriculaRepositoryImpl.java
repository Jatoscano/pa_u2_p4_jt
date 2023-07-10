package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Matricula;
import com.example.demo.uce.edu.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

	//DTO
	@Override
	public List<MatriculaDTO> seleccionarTodoDTO(String noombreEstudiante, String nombreMateria) {

		TypedQuery<MatriculaDTO> myTypedQuery = this.entityManager.createQuery(
				
				"SELECT NEW com.example.demo.uce.edu.repository.modelo.dto.MatriculaDTO(e.alumno.nombre, e.materia.nombre) FROM Matricula e ", MatriculaDTO.class);
		
		return myTypedQuery.getResultList();
	}
}
