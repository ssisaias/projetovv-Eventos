package br.projetovv.dao;

import java.util.List;

import br.projetovv.modelo.Evento;

public interface IEventoDAO {

	public void inserir(Evento evento);
	public void alterar(Evento evento);
	public List<Evento> listar();
	public Evento buscar(Long id);
	public void remover(Long id);
	
}
