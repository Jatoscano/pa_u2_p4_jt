package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.modelo.Habitacion;

public interface HabitacionRepository {

	public void insertar(Habitacion habitacion);
	public void actualizar(Habitacion habitacion);
    public Habitacion seleccionar(Integer id);
	public void eliminar(Integer id);
}
