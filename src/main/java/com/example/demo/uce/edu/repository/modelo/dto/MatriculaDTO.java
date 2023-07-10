package com.example.demo.uce.edu.repository.modelo.dto;

public class MatriculaDTO {

    private String nombreEstudiante;
	private String nombreMateria;
	
	//Constructor por Defecto
	public MatriculaDTO() {
	}
	
	//Constructor
	public MatriculaDTO(String nombreEstudiante, String nombreMateria) {
		super();
		this.nombreEstudiante = nombreEstudiante;
		this.nombreMateria = nombreMateria;
	}

	@Override
	public String toString() {
		return "MatriculaDTO [nombreEstudiante=" + nombreEstudiante + ", nombreMateria=" + nombreMateria + "]";
	}
	
	//Get and Set
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	
}
