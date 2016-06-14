package br.projetovv.dao;

import java.util.List;

import br.projetovv.modelo.Sala;

public interface ISalaDAO {
	
	public void inserir(Sala sala);
	public void alterar(Sala sala);
	public Sala recuperar(Long idSala);
	public List<Sala> listar();
	public Sala buscar(String nome);
	public void remover(Long idSala);
}
