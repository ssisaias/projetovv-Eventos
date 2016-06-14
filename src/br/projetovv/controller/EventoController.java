package br.projetovv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.projetovv.dao.IEventoDAO;
import br.projetovv.modelo.Evento;
import br.projetovv.modelo.Sala;
import br.projetovv.stub.Filme;
import br.projetovv.stub.FilmeDAO;
import br.projetovv.dao.SalaDAO;

@Transactional
@Controller
public class EventoController {

	@Qualifier(value = "eventoDAO")
	@Autowired
	private IEventoDAO eDAO;
	
	@Qualifier(value="filmeDAO")
	@Autowired
	private FilmeDAO fDAO;
	
	@Qualifier(value="salaDAO")
	@Autowired
	private SalaDAO sDAO;

	@PersistenceContext
	private EntityManager manager;
	
	@RequestMapping("/formAddEvento")
	public String form(Model m) {
				
		m.addAttribute("salas", this.sDAO.listar());
		m.addAttribute("filmes", this.fDAO.listar());
		
		return "evento/formularioNovoEvento";
	}

	@RequestMapping("/adicionaEvento")
	public String adicionaEvento(@RequestParam(value="filmeId", required=true) String filmeId,
			@RequestParam(value="salaId", required=true) String salaId, Evento evento) {
		
		Long idFilme = Long.valueOf(filmeId);
		Long idSala = Long.valueOf(salaId);
		
		evento.setFilme((Filme)manager.createQuery("SELECT f FROM filme AS f WHERE f.id = :param_id")
				.setParameter("param_id", idFilme).getSingleResult());
		evento.setSala((Sala)manager.createQuery("SELECT s FROM sala AS s WHERE s.id = :param_id")
				.setParameter("param_id", idSala).getSingleResult());
		
		this.eDAO.inserir(evento);
		
		return "evento/eventoAdicionado";
	}

	@RequestMapping("/alteraEvento")
	public String alteraEvento(@RequestParam(value="filmeId", required=true) String filmeId,
			@RequestParam(value="salaId", required=true) String salaId, Evento evento) {

		Long idFilme = Long.valueOf(filmeId);
		Long idSala = Long.valueOf(salaId);
		
		evento.setFilme((Filme)manager.createQuery("SELECT f FROM filme AS f WHERE f.id = :param_id")
				.setParameter("param_id", idFilme).getSingleResult());
		evento.setSala((Sala)manager.createQuery("SELECT s FROM sala AS s WHERE s.id = :param_id")
				.setParameter("param_id", idSala).getSingleResult());

		this.eDAO.alterar(evento);
		
		return "redirect:/listaEventos";
	}

	@RequestMapping("/listaEventos")
	public String listaEventos(Model mv) {

		mv.addAttribute("eventos", this.eDAO.listar());

		return "evento/lista";
	}

	@RequestMapping("/mostraEvento")
	public String mostraEvento(Long id, Model m) {

		m.addAttribute("salas", this.sDAO.listar());
		m.addAttribute("filmes", this.fDAO.listar());
		m.addAttribute("evento", this.eDAO.buscar(id));

		return "evento/mostra";
	}

	@RequestMapping("/apagaEvento")
	public String apagaEvento(Evento evento) {

		this.eDAO.remover(evento.getId());

		return "redirect:/listaEventos";
	}
	
	public List<Evento> getEventosPorSala(List<Sala> salas){
		List<Evento> lista = eDAO.listar();
		for (Evento evento : lista) {
			boolean esta = false;
			for (Sala sala : salas) {
				if (evento.getSala().getIdSala() == sala.getIdSala()) {
					esta = true;
				}
			}
			if (!esta) {
				lista.remove(evento);
			}
		}
		return lista;
	}
	
	public List<Sala> getSalasPorFilmes(Filme filme){
		List<Sala> salas = new ArrayList<Sala>();
		List<Evento> eventos = eDAO.listar();
		for (Evento evento : eventos) {
			if (evento.getFilme().getIdFilme() == filme.getIdFilme()) {
				salas.add(evento.getSala());
			}
		}
		return salas;
	}
	
	
}
