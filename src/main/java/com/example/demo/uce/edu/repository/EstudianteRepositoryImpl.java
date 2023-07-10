package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Estudiante;
import com.example.demo.uce.edu.repository.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Estudiante estudiante) {
	
		this.entityManager.persist(estudiante);
		
	}
	@Override
	public void actualizar(Estudiante estudiante) {
		
		this.entityManager.merge(estudiante);
		
	}
	@Override
	public Estudiante seleccionar(String cedula) {
		
		return this.entityManager.find(Estudiante.class, cedula);
		
	}
	@Override
	public void eliminar(String cedula) {
		
		Estudiante estudiante = this.seleccionar(cedula);
		this.entityManager.remove(estudiante);
		
	}
	
	//Query
	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		
		//SQL
		//SLEECT * FROM  estudiante e WHERE e.estu_apellido = 
		
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT e FROM Estudiante e WHERE e.apellido =
		
		Query myQuery =  this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante)myQuery.getSingleResult();
	}
	
	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		
		Query myQuery =  this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		
		return myQuery.getResultList();

	}
	
	@Override
	public Estudiante seleccionarPorApellidoYNombre(String apellido, String nombre) {
		
		Query myQuery =  this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.nombre = :datoNombre");
		
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		
		return (Estudiante)myQuery.getSingleResult();
	}
	
	//Typed Query
	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		
		TypedQuery<Estudiante> mQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido"
				, Estudiante.class);
		mQuery.setParameter("datoApellido", apellido);
		
		return mQuery.getSingleResult();
	}

	//Named Query
	@Override
	public Estudiante seleccionarPorApellidos(String apellido) {
		TypedQuery<Estudiante> mQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorApellido",
				                                                             Estudiante.class);
		mQuery.setParameter("datoApellido", apellido);
		return mQuery.getSingleResult();
	}
	
	@Override
	public Estudiante seleccionarPorApellidosNamedQuery(String apellido) {
		
		Query mQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorApellido",
                Estudiante.class);
		mQuery.setParameter("datoApellido", apellido);
		return (Estudiante)mQuery.getSingleResult();
	}
	
	@Override
	public Estudiante seleccionarPorNombreNamedQuery(String nombre) {
		Query mQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorNombre",
                                                            Estudiante.class);
		mQuery.setParameter("datoNombre", nombre);
		return (Estudiante)mQuery.getSingleResult();
	}
	
	//Native Query
	@Override
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido) {
		//SQL
		//SELECT * FROM estudiante WHERE estu_apellido = :datoApellido
		//Hay que colocar el nombre de la tabla 
		Query mQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_apellido = :datoApellido", 
				                             Estudiante.class);
		mQuery.setParameter("datoApellido", apellido);
		return (Estudiante)mQuery.getSingleResult();
	}
	
	@Override
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido) {
		TypedQuery<Estudiante> typedQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorApellidoNative", Estudiante.class);
		typedQuery.setParameter("datoApellido", apellido);
		return typedQuery.getSingleResult();
	}
	
	@Override
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre) {
		TypedQuery<Estudiante> typedQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorNombreNative", 
				                                                                 Estudiante.class);
		typedQuery.setParameter("datoNombreNative", nombre);
		return typedQuery.getSingleResult();
	}
	
	//Criteria API
	@Override
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido) {
	
		//Construye desde cero el SQL
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		
		//1. Especficar el tipo de retorno del Query - Sintesis del Typed Query
		CriteriaQuery<Estudiante> myCriteriaQuery = myBuilder.createQuery(Estudiante.class);
		
		//2. Empezamos a crear el SQL
		//2.1 Definimos el FRONT -> El FROM en Criteria API Query se lo conoce como RooT
		Root<Estudiante> miTablaFrom = myCriteriaQuery.from(Estudiante.class); //FROM Estudiante
		
		//3. Construir las condiciones de mi SQL -> WHERE ->
		//Las condiciones se las conoce como Predicados
		//e.apellido = :datoApellido
		Predicate condicionApellido = myBuilder.equal( miTablaFrom.get("apellido"), apellido); 
		
		//4. Armamos mi SQL final 
		myCriteriaQuery.select(miTablaFrom).where(condicionApellido);
		
		//5. Ejecuccion del Query lo realizamos con TypedQuery
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);
		return myQueryFinal.getSingleResult();
	}
	
	@Override
	public Estudiante seleccionarEstudianteDinamico(String nombre, String apellido, Double peso) {
		
		//Construye desde cero el SQL
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
				
		//1. Especficar el tipo de retorno del Query - Sintesis del Typed Query
		CriteriaQuery<Estudiante> myCriteriaQuery = myBuilder.createQuery(Estudiante.class);
				
		//2. Empezamos a crear el SQL
		//2.1 Definimos el FRONT -> El FROM en Criteria API Query se lo conoce como RooT
		Root<Estudiante> miTablaFrom = myCriteriaQuery.from(Estudiante.class); //FROM Estudiante
				
		//3. Construir las condiciones de mi SQL -> WHERE ->
	    //Las condiciones se las conoce como Predicados

		// cond > 100 -> e.nombre = ? AND e.apellido = ?
		// cond < 100 -> e.nombre = ? OR e.apellido = ?
		
		//e.nombre = ?
		Predicate pNombre = myBuilder.equal( miTablaFrom.get("nombre"), nombre); 
				
		//e.apellido = ?
		Predicate pApellido = myBuilder.equal( miTablaFrom.get("apellido"), apellido);
		
		//Predicado null
		Predicate predicadoFinal = null;
		
		if(peso.compareTo(Double.valueOf(100)) <= 0) {
			predicadoFinal = myBuilder.or(pNombre, pApellido);
		}
		else {
			predicadoFinal = myBuilder.and(pNombre, pApellido);
		}
		
		//4. Armamos mi SQL final 
		myCriteriaQuery.select(miTablaFrom).where(predicadoFinal);
				
		//5. Ejecuccion del Query lo realizamos con TypedQuery
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);
		return myQueryFinal.getSingleResult();
	}
	@Override
	public int elimimarPorNombre(String nombre) {
		//SQL
		//DELETE FROM estudiante WHERE estu_nombre =?
		
		//JPQL
		//DELETE FROM Estudiante e WHERE e.nombre = :datoNombre
		
		Query myQuery = this.entityManager.createQuery("DELETE FROM Estudiante e WHERE e.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);	
	    return myQuery.executeUpdate(); //
	}
	@Override
	public int actualizarPorApellido(String nombre, String apellido) {
		
		//SQL
		//UPDATE estudiante SET estu_nombre =? WHERE estu_apellido =?
		
		//JPQL
		//UPDATE Estudiante e SET e.nombre = :datoNombre WHERE e.apellido = :datoApellido
		Query myQuery = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre = :datoNombre WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);	
	    return myQuery.executeUpdate(); 
	}
	
	//DTO
	@Override
	public List<EstudianteDTO> seleccionarTodosDTO(String nombre, String apellido) {
		
		TypedQuery<EstudianteDTO> myTypedQuery = this.entityManager.createQuery(
				
				"SELECT NEW com.example.demo.uce.edu.repository.modelo.dto.EstudianteDTO(e.nombre, e.apellido) FROM Estudiante e ", EstudianteDTO.class);
		
		return myTypedQuery.getResultList();
	}
}
