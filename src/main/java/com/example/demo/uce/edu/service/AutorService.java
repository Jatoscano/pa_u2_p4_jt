package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.modelo.Autor;

public interface AutorService {

	public void registrar(Autor autor);
	public void guardar(Autor autor);
    public Autor buscar(Integer id);
	public void borrar(Integer id);
}
