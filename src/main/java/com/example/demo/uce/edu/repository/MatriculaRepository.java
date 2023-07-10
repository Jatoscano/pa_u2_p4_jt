package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.modelo.Matricula;
import com.example.demo.uce.edu.repository.modelo.dto.MatriculaDTO;

public interface MatriculaRepository {

	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
    public Matricula seleccionar(Integer id);
	public void eliminar(Integer id);
	
	//DTO
	public List<MatriculaDTO> seleccionarTodoDTO(String noombreEstudiante, String nombreMateria);
}
