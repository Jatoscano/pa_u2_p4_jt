package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.AutorRepository;
import com.example.demo.uce.edu.repository.modelo.Autor;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public void registrar(Autor autor) {
		
		this.autorRepository.insertar(autor);
	}

	@Override
	public void guardar(Autor autor) {
		
		this.autorRepository.actualizar(autor);
	}

	@Override
	public Autor buscar(Integer id) {
		
		return this.autorRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.autorRepository.eliminar(id);
	}

}
