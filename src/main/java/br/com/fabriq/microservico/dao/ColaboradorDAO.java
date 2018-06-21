package br.com.fabriq.microservico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.fabriq.microservico.model.Colaborador;
import br.com.fabriq.microservico.model.Grafico;

@Repository
@Transactional
public class ColaboradorDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Colaborador colaborador) {
		manager.persist(colaborador);
	}
	
	public void excluir(Colaborador colaborador) {
		manager.remove(colaborador);
	}

	public List<Colaborador> listar() {
		return manager.createQuery("select c from colaborador c", Colaborador.class)
				.getResultList();
	}

	public Colaborador find(Integer id) {
        return manager.createQuery("select c from colaborador c where c.id = :id", Colaborador.class).setParameter("id", id).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Grafico> grafico() {
		return manager.createQuery("select distinct d.nome, count(c.id) as qtd from colaborador c inner join c.departamento d where c.departamento.id = d.id group by d.nome")
				.getResultList();
	}

}
