package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.modelo.Habitacion;

public interface HabitacionService {

	public void registar(Habitacion habitacion);
	public void guardar(Habitacion habitacion);
    public Habitacion buscar(Integer id);
	public void borrar(Integer id);
}
