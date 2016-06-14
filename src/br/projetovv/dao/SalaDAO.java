package br.projetovv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.projetovv.modelo.Sala;
import br.projetovv.stub.Cinema;

@Repository
public class SalaDAO implements ISalaDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Sala sala){
		Cinema c = manager.find(Cinema.class, 1L);
		sala.setCinema(c);
		
		manager.persist(sala);
	}
	
	public void alterar(Sala sala){
		manager.merge(sala);
	}
	
	public Sala recuperar(Long idSala){
		return manager.find(Sala.class, idSala);
	}
	
	public List<Sala> listar(){
		return manager.createQuery("SELECT s FROM sala AS s", Sala.class).getResultList();
	}
	
	public Sala buscar(String nome){
		String hql = "SELECT s FROM sala AS s WHERE s.nome = :param_nome";
	
		Query query = manager.createQuery(hql);
		List<Sala> salas = query.setParameter("param_nome", nome).getResultList();
	
		if(salas.size()!=0){
			return salas.get(0);
		}
	
	return null;

	}
	
	public void remover(Long idSala){
		Sala ref = this.recuperar(idSala);
		if(ref != null){
			manager.remove(ref);	
		}
		
	}

	
	
}
