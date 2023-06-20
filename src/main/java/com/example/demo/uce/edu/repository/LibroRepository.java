package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.modelo.Libro;

public interface LibroRepository {

	public void insertar(Libro libro);
	public void actualizar(Libro libro);
    public Libro seleccionar(Integer id);
	public void eliminar(Integer id);
}
