package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.modelo.Hotel;

public interface HotelRepository {

	public void insertar(Hotel hotel);
	public void actualizar(Hotel hotel);
    public Hotel seleccionar(Integer id);
	public void eliminar(Integer id);
}
