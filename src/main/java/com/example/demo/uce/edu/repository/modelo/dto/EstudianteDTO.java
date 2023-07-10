package com.example.demo.uce.edu.repository.modelo.dto;

public class EstudianteDTO {

	private String nombre;
	private String apellido;
	

    public EstudianteDTO() {
		
	}
			
	//Constructor Estudiante
	public EstudianteDTO(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
	@Override
	public String toString() {
		return "EstudianteDTO [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	//Get and Set
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
