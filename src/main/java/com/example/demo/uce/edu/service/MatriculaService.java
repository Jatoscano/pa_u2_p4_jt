package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.modelo.Matricula;
import com.example.demo.uce.edu.repository.modelo.dto.MatriculaDTO;

public interface MatriculaService {

	public void registrar(Matricula matricula);
	public void guardar(Matricula matricula);
    public Matricula buscar(Integer id);
	public void borrar(Integer id);
	
	//DTO
	public List<MatriculaDTO> buscarTodoDTO(String noombreEstudiante, String nombreMateria);
}
