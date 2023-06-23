package com.example.demo.uce.edu.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "matricula", schema = "public")
@Entity
public class Matricula {

	@Id
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@Column(name = "mtla_id")
	private Integer id;
	
	@Column(name = "mtla_fechaDeMatricula")
	private LocalDateTime fechaDeMatricula;
	
	@Column(name = "mtla_numeroDeMatricula")
	private String numeroDeMatricula;
	
	@ManyToOne(cascade = CascadeType.ALL)
	// el ultimo nombre defino en la clase se define en la clase Alumno
	@JoinColumn(name = "mtla_id_alumno")
	private Alumno alumno;
	
	@ManyToOne(cascade = CascadeType.ALL)
	// el ultimo nombre defino en la clase se define en la clase Materia
	@JoinColumn(name = "mtla_id_materia")
	private Materia materia;

	
	//get and set
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaDeMatricula=" + fechaDeMatricula + ", numeroDeMatricula="
				+ numeroDeMatricula + ", alumno=" + alumno + ", materia=" + materia + "]";
	}

	//get and set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaDeMatricula() {
		return fechaDeMatricula;
	}

	public void setFechaDeMatricula(LocalDateTime fechaDeMatricula) {
		this.fechaDeMatricula = fechaDeMatricula;
	}

	public String getNumeroDeMatricula() {
		return numeroDeMatricula;
	}

	public void setNumeroDeMatricula(String numeroDeMatricula) {
		this.numeroDeMatricula = numeroDeMatricula;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	
	
}
