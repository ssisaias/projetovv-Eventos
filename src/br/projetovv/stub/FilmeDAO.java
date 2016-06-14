package br.projetovv.stub;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class FilmeDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Filme> listar() {
		return manager.createQuery("SELECT f FROM filme AS f", Filme.class).getResultList();
	}

	public Filme buscar(Long id) {
		return (Filme) manager.createQuery("SELECT f FROM filme AS f WHERE f.id = :param_id")
				.setParameter("param_id", id).getSingleResult();
	}

}
