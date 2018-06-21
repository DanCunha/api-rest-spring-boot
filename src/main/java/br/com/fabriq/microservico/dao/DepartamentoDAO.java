package br.com.fabriq.microservico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.fabriq.microservico.model.Departamento;

@Repository
@Transactional
public class DepartamentoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Departamento> listar() {
		return manager.createQuery("select c from departamento c", Departamento.class)
				.getResultList();
	}
}
