package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.modelo.Ciudadano;

public interface CiudadanoService {

	public void registrar(Ciudadano ciudadano);
	public void guardar(Ciudadano ciudadano);
    public Ciudadano buscar(Integer id);
	public void borrar(Integer id);
}
