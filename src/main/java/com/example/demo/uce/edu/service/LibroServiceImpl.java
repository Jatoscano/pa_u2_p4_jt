package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.LibroRepository;
import com.example.demo.uce.edu.repository.modelo.Libro;
@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public void registrar(Libro libro) {
		
		this.libroRepository.insertar(libro);
	}

	@Override
	public void guardar(Libro libro) {
		
		this.libroRepository.actualizar(libro);
	}

	@Override
	public Libro buscar(Integer id) {
		
		return this.libroRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.libroRepository.eliminar(id);
	}

}
