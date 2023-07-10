package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.MatriculaRepository;
import com.example.demo.uce.edu.repository.modelo.Matricula;
import com.example.demo.uce.edu.repository.modelo.dto.MatriculaDTO;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Override
	public void registrar(Matricula matricula) {
		
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	public void guardar(Matricula matricula) {
		
		this.matriculaRepository.actualizar(matricula);
	}

	@Override
	public Matricula buscar(Integer id) {
		
		return this.matriculaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.matriculaRepository.eliminar(id);
	}

	//DTO
	@Override
	public List<MatriculaDTO> buscarTodoDTO(String noombreEstudiante, String nombreMateria) {
		
		return this.matriculaRepository.seleccionarTodoDTO(noombreEstudiante, nombreMateria);
	}
	
	

}
