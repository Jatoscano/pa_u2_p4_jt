package com.example.demo.uce.edu.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "alumno", schema = "public")
@Entity
public class Alumno {

	@Id
	@SequenceGenerator(name = "seq_alumno", sequenceName = "seq_alumno", allocationSize = 1)
	@GeneratedValue(generator = "seq_alumno", strategy = GenerationType.SEQUENCE)
	@Column(name = "alumn_id")
	private Integer id;
	
	@Column(name = "alumn_nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "alumno")
	private List<Matricula> matriculas;
	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", matriculas=" + matriculas + "]";
	}

	//get and set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	
	
}
