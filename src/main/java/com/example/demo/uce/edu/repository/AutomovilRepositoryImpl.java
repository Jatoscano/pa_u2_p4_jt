package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Automovil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutomovilRepositoryImpl implements AutomovilRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Automovil automovil) {
		
		this.entityManager.persist(automovil);
	}

	@Override
	public void actualizar(Automovil automovil) {
		
		this.entityManager.merge(automovil);
	}

	@Override
	public Automovil seleccionar(Integer id) {
		
		return this.entityManager.find(Automovil.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	//Query
	@Override
	public Automovil seleccionarModelo(String modelo) {
		//SQL
		//SELECT * FROM  automovil e WHERE e.auto_modelo = 
				
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT e FROM Automovil e WHERE e.modelo = :""
		
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Automovil e WHERE "
				                                     + "e.modelo = :datoModelo");
		myQuery.setParameter("datoModelo", modelo);
		return (Automovil)myQuery.getSingleResult();
	}

	@Override
	public List<Automovil> seleccionarMarcaYModelo(String marca, String modelo) {
		
		//SQL
		//SELECT * FROM  automovil e WHERE e.auto_marca =  AND e.auto_modelo = 
						
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT e FROM Automovil e WHERE e.marca = :"" AND e.modelo = :""
		
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Automovil e WHERE "
				                                    + "e.marca =:datoMarca AND "
				                                    + "e.modelo = :datoModelo");
		myQuery.setParameter("datoMarca", marca);
		myQuery.setParameter("datoModelo", modelo);
		return myQuery.getResultList();
	}
	
	//TypedQuery

	@Override
	public Automovil seleccionarModeloTyped(String modelo) {
		
		//SQL
		//SELECT * FROM  automovil e WHERE e.auto_modelo = 
						
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT e FROM Automovil e WHERE e.modelo = :""
		
		TypedQuery<Automovil> myQuery = this.entityManager.createQuery("SELECT e FROM Automovil e WHERE "
                                                                     + "e.modelo = :datoModelo",
                                                                     Automovil.class);
		myQuery.setParameter("datoModelo", modelo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Automovil> seleccionarPorAnio(Integer anio) {
		//SQL
		//SELECT * FROM  automovil e WHERE e.auto_anio >= 
								
	    //JPQL
		//Se mantienen las palabras reservadas 
		//SELECT e FROM Automovil e WHERE e.anio >= :""
		TypedQuery<Automovil> myQuery = this.entityManager.createQuery("SELECT e FROM Automovil e WHERE "
                                                                     + "e.anio >= :datoAnio",
                Automovil.class);
        myQuery.setParameter("datoAnio", anio);
        return myQuery.getResultList();
	}	
	
}
