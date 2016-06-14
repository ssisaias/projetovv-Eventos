package br.projetovv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.projetovv.modelo.Evento;

@Repository
public class EventoDAO implements IEventoDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Evento evento) {
		manager.persist(evento);
	}

	@Override
	public void alterar(Evento evento) {
		manager.merge(evento);

	}

	@Override
	public List<Evento> listar() {
		return manager.createQuery("SELECT e FROM evento AS e", Evento.class).getResultList();
	}

	@Override
	public Evento buscar(Long id) {
		try{
			return (Evento) manager.createQuery("SELECT e FROM evento AS e WHERE e.id = :param_id")
				.setParameter("param_id", id).getSingleResult();
		}
		catch(javax.persistence.NoResultException e){
			System.out.println("Entidade nao encontrada : " + id);
			throw e;
		}
	}

	@Override
	public void remover(Long id) {
		Evento ref = this.buscar(id);
		if (ref != null) {
			manager.remove(ref);
		}
	}

}
