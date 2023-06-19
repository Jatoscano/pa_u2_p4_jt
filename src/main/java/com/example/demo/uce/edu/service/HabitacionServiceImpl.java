package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.HabitacionRepository;
import com.example.demo.uce.edu.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements HabitacionService{

	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Override
	public void registar(Habitacion habitacion) {
		
		this.habitacionRepository.insertar(habitacion);
	}

	@Override
	public void guardar(Habitacion habitacion) {
		
		this.habitacionRepository.actualizar(habitacion);
	}

	@Override
	public Habitacion buscar(Integer id) {
		
		return this.habitacionRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.habitacionRepository.eliminar(id);
	}

}
