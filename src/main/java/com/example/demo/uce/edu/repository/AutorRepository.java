package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.modelo.Autor;

public interface AutorRepository {

	public void insertar(Autor autor);
	public void actualizar(Autor autor);
    public Autor seleccionar(Integer id);
	public void eliminar(Integer id);
	
}
