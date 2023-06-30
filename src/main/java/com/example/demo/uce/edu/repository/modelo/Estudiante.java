package com.example.demo.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "estudiante",schema = "public")
@Entity

@NamedQueries({@NamedQuery(name = "Estudiante.buscaPorApellido",
                           query = "SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido"),
			   @NamedQuery(name = "Estudiante.buscaPorNombre",
			   			   query = "SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre")})


@NamedNativeQueries({@NamedNativeQuery(name = "Estudiante.buscaPorApellidoNative", 
                                       query = "SELECT * FROM estudiante WHERE estu_apellido = :datoApellido",
                                       resultClass = Estudiante.class),
	                 @NamedNativeQuery(name = "Estudiante.buscaPorNombreNative", 
	                 				   query = "SELECT * FROM estudiante WHERE estu_nombre = :datoNombreNative",
	                 				   resultClass = Estudiante.class)})

public class Estudiante {

	@Id
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
	@Column(name = "estu_id")
	private Integer id;
	
	@Column(name = "estu_nombre")
	private String nombre;
	
	@Column(name = "estu_apellido")
	private String apellido;
	
	@Column(name = "estu_edad")
	private String edad;
	
	
	@Column(name = "estu_cedula")
	private String cedula;
	
	
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cedula=" + cedula
				+ "]";
	}
	//get and set
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
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
}
