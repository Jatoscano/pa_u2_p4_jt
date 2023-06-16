package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.modelo.Empleado;

public interface EmpleadoService {
	
	public void registrar(Empleado empleado);
	public void guardar(Empleado empleado);
    public Empleado buscar(Integer id);
	public void borrar(Integer id);
}
