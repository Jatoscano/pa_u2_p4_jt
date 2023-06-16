package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.modelo.Empleado;

public interface EmpleadoRepository {

	public void insertar(Empleado empleado);
	public void actualizar(Empleado empleado);
    public Empleado seleccionar(Integer id);
	public void eliminar(Integer id);
}
