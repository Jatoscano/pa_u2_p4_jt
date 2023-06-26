package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.AutomovilRepository;
import com.example.demo.uce.edu.repository.modelo.Automovil;

@Service
public class AutomovilServiceImpl implements AutomovilService{

	@Autowired
	private AutomovilRepository automovilRepository;
	
	@Override
	public void registrar(Automovil automovil) {
		
		this.automovilRepository.insertar(automovil);
	}

	@Override
	public void guardar(Automovil automovil) {
		
		this.automovilRepository.actualizar(automovil);
	}

	@Override
	public Automovil buscar(Integer id) {
		
		return this.automovilRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.automovilRepository.eliminar(id);
	}

	//Query
	@Override
	public Automovil buscarModelo(String modelo) {
		
		return this.automovilRepository.seleccionarModelo(modelo);
	}

	@Override
	public List<Automovil> reporteDeAutomoviles(String marca, String modelo) {
		
		return this.automovilRepository.seleccionarMarcaYModelo(marca, modelo);
	}

	//TypedQuery
	@Override
	public Automovil buscarModeloTyped(String modelo) {
		
		return this.automovilRepository.seleccionarModeloTyped(modelo);
	}

	@Override
	public List<Automovil> reportePorAnio(Integer anio) {
		
		return this.automovilRepository.seleccionarPorAnio(anio);
	}
	
	

}
