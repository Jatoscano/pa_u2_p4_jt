package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.modelo.Ciudadano;

public interface CiudadanoRepository {

	public void insertar(Ciudadano ciudadano);
	public void actualizar(Ciudadano ciudadano);
    public Ciudadano seleccionar(Integer id);
	public void eliminar(Integer id);
}
