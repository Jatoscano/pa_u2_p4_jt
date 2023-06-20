package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.modelo.Libro;

public interface LibroService {

	public void registrar(Libro libro);
	public void guardar(Libro libro);
    public Libro buscar(Integer id);
	public void borrar(Integer id);
}
