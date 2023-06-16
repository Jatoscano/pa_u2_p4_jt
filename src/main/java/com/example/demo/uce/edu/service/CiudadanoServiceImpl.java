package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.CiudadanoRepository;
import com.example.demo.uce.edu.repository.modelo.Ciudadano;

@Service
public class CiudadanoServiceImpl implements CiudadanoService{

	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	@Override
	public void registrar(Ciudadano ciudadano) {
		
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public void guardar(Ciudadano ciudadano) {
		
		this.ciudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public Ciudadano buscar(Integer id) {
	
		return this.ciudadanoRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.ciudadanoRepository.eliminar(id);
	}

}
