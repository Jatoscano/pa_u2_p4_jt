package com.example.demo.uce.edu.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.uce.edu.repository.modelo.Automovil;
import com.example.demo.uce.edu.repository.modelo.dto.AutomovilDTO;

public interface AutomovilRepository {

	public void insertar(Automovil automovil);
	public void actualizar(Automovil automovil);
    public Automovil seleccionar(Integer id);
	public void eliminar(Integer id);
	
	//Query
	public Automovil seleccionarModelo(String modelo);
	public List<Automovil> seleccionarMarcaYModelo(String marca, String modelo);
	
	//TypedQuery
	public Automovil seleccionarModeloTyped(String modelo);
	public List<Automovil> seleccionarPorAnio(Integer anio);
	
	//Criteria API Query
	public Automovil seleccionarAutomovilDinamico(String marca, String modelo, Double potenciaMotor);
	
	//UPDATE - DELETE
	public int elimimarPorMarca(String marca);
	public int actualizarPorModelo(String marca, String modelo);
	
	//DTO
	public List<AutomovilDTO> seleccionarDTO (String modelo, String marca, BigDecimal precio);
}
