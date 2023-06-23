package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.modelo.Matricula;

public interface MatriculaRepository {

	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
    public Matricula seleccionar(Integer id);
	public void eliminar(Integer id);
}
