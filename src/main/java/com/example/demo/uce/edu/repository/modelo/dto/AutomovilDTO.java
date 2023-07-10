package com.example.demo.uce.edu.repository.modelo.dto;

import java.math.BigDecimal;

public class AutomovilDTO {

	private String modelo;
	private String marca;
	private BigDecimal precio;
	
	public AutomovilDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AutomovilDTO(String modelo, String marca, BigDecimal precio) {
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
	}
	
	
	

	@Override
	public String toString() {
		return "AutomovilDTO [modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + "]";
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
}
