package com.pacoillan.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pacoillan.objetos.Categoria;

@Repository
public class CategoriaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void insertar (Categoria categoria) {
		em.persist(categoria);
	}
	@Transactional
	public void borrar (Categoria categoria) {
		em.remove(em.merge(categoria));
	}
	@Transactional
	public void actualizar(Categoria categoria) {
		em.merge(categoria);
	}
	
	public List<Categoria> buscaTodas(){
		
		TypedQuery<Categoria> consultaJPA = em.createQuery("select c from Categoria c",Categoria.class);
		return consultaJPA.getResultList();
		
	}

}
