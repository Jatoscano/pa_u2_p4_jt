package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.modelo.Automovil;

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

	//Criteria API Query
	@Override
	public Automovil seleccionarAutomovilDinamico(String marca, String modelo, Double potenciaMotor) {
		//Construye desde cero el SQL
				CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
						
				//1. Especficar el tipo de retorno del Query - Sintesis del Typed Query
				CriteriaQuery<Automovil> myCriteriaQuery = myBuilder.createQuery(Automovil.class);
						
				//2. Empezamos a crear el SQL
				//2.1 Definimos el FRONT -> El FROM en Criteria API Query se lo conoce como RooT
				Root<Automovil> miTablaFrom = myCriteriaQuery.from(Automovil.class); //FROM Estudiante
						
				//3. Construir las condiciones de mi SQL -> WHERE ->
			    //Las condiciones se las conoce como Predicados

				// cond > 1.2 -> e.marca = ? AND e.modelo = ?
				// cond < 1.2 -> e.marca = ? OR e.modelo = ?
				
				//e.nombre = ?
				Predicate pMarca = myBuilder.equal( miTablaFrom.get("marca"), marca); 
						
				//e.apellido = ?
				Predicate pModelo = myBuilder.equal( miTablaFrom.get("modelo"), modelo);
				
				//Predicado null
				Predicate predicadoFinal = null;
				
				if(potenciaMotor.compareTo(Double.valueOf(1.2)) <= 0) {
					predicadoFinal = myBuilder.or(pMarca, pModelo);
				}
				else {
					predicadoFinal = myBuilder.and(pMarca, pModelo);
				}
				
				//4. Armamos mi SQL final 
				myCriteriaQuery.select(miTablaFrom).where(predicadoFinal);
						
				//5. Ejecuccion del Query lo realizamos con TypedQuery
				TypedQuery<Automovil> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);
				return myQueryFinal.getSingleResult();
	}

	//UPDATE - DELETE
	@Override
	public int elimimarPorMarca(String marca) {
		//SQL
		//DELETE FROM automovil WHERE auto_marca =?
					
		//JPQL
		//DELETE FROM Automovil e WHERE e.marca = :datoMarca
					
		Query myQuery = this.entityManager.createQuery("DELETE FROM Automovil e WHERE e.marca = :datoMarca");
		myQuery.setParameter("datoMarca", marca);	
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarPorModelo(String marca, String modelo) {
		//SQL
		//UPDATE automovil SET auto_marca =? WHERE auto_modelo =?
					
		//JPQL
		//UPDATE Automovil e SET e.marca = :datoMarca WHERE e.modelo = :datoModelo
		Query myQuery = this.entityManager.createQuery("UPDATE Automovil e SET e.marca = :datoMarca WHERE e.modelo = :datoModelo");
		myQuery.setParameter("datoMarca", marca);
		myQuery.setParameter("datoModelo", modelo);	
		return myQuery.executeUpdate();
	}
}
