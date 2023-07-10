package com.example.demo.uce.edu.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.uce.edu.repository.modelo.Automovil;
import com.example.demo.uce.edu.repository.modelo.dto.AutomovilDTO;

public interface AutomovilService {

	public void registrar(Automovil automovil);
	public void guardar(Automovil automovil);
    public Automovil buscar(Integer id);
	public void borrar(Integer id);
	
	//Query
	public Automovil buscarModelo(String modelo);
	public List<Automovil> reporteDeAutomoviles(String marca, String modelo);
		
	//TypedQuery
	public Automovil buscarModeloTyped(String modelo);
	public List<Automovil> reportePorAnio(Integer anio);
	
	//Criteria API Query
	public Automovil buscarAutomovilDinamico(String marca, String modelo, Double potenciaMotor);
		
	//UPDATE - DELETE
	public int borrarPorMarca(String marca);
	public int guardarPorModelo(String marca, String modelo);
	
	//DTO
	public List<AutomovilDTO> buscarDTO (String modelo, String marca, BigDecimal precio);
}
