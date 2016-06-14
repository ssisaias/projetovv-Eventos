package br.projetovv.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.projetovv.dao.EventoDAO;
import br.projetovv.modelo.Evento;
import br.projetovv.modelo.Sala;
import br.projetovv.stub.Filme;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-context.xml"})
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EventoTestesUnitario extends AbstractTransactionalJUnit4SpringContextTests {
		
		@Autowired
		EventoDAO dao;
		
		
		@Test
		public void atesteAdicionaEventoValidoBancoUsandoDAO() {
			//EventoDAO dao = new EventoDAO();
			Evento ev = new Evento();
			Sala sala = new Sala();
			Filme filme = new Filme();
			sala.setIdSala(1l);
			filme.setIdFilme(1l);
			ev.setSala(sala);
			ev.setFilme(filme);
			Date data = new Date(2016,04,27,13,56);
			ev.setDataEvento(data);
			dao.inserir(ev);
			System.out.println("id do evento"+ev.getId());
			Assert.assertNotNull(ev);
			Assert.assertEquals(ev.getDataEvento(), data);
		}
	
		@Test
		public void btesteBuscaEventoExistenteBanco(){
			Evento ev = dao.buscar(3l);
			Assert.assertNotNull(ev);
			Assert.assertNotNull(ev.getId());
		}		
		
		@Test
		public void ctesteAlteraEventoBanco(){
			Evento ev = dao.buscar(3l);
			if (ev == null) {
				fail();
			}
			Filme filme = new Filme();
			filme.setIdFilme(7l);
			filme.setNomeFilme("teste");
			ev.setFilme(filme);
			dao.alterar(ev);
			Assert.assertEquals(ev.getFilme(), filme);
		}
		
		@Test
		public void dtesteRemoveEventoExistenteBanco(){
			dao.remover(3l);
			Evento e = dao.buscar(3l);
			Assert.assertEquals(null, e);
		}
		
		@Test
		public void etesteListarTodosEventos(){
			long tamanho = dao.listar().size(); 
			for (int i = 0; i < 2; i++) {
				Evento ev = new Evento();
				Sala sala = new Sala();
				Filme filme = new Filme();
				sala.setIdSala(1l);
				filme.setIdFilme(1l);
				ev.setSala(sala);
				ev.setFilme(filme);
				Date data = new Date(2016,04,27,13,56);
				ev.setDataEvento(data);
				dao.inserir(ev);
			}
			List<Evento> list = dao.listar();
			Assert.assertNotNull(list);
			Assert.assertEquals(tamanho+2, list.size());
		}
		
		@Test(expected=PersistenceException.class)
		public void ftesteAdicionaEventoInvalidoSemFilme(){
			Evento ev = new Evento();
			Sala sala = new Sala();
			sala.setIdSala(1l);
			ev.setSala(sala);
			Date data = new Date();
			ev.setDataEvento(data);
			dao.inserir(ev);
		}
		
		@Test(expected=NoResultException.class)
		public void gtesteBuscaEventoInexistenteBanco(){
			Evento ev = dao.buscar(66l);
		}
		
		@Test(expected=NoResultException.class)
		public void testeRemoveEventoInexistenteBanco(){
			dao.remover(66l);
		}
		
		@Test
		public void testaSeRetornaEventosDasSalas(){
			//pre condicao: sala existente, evento existente
			
			
		}
		@Test
		public void testaAsSalasQueEstaPassandoDeterminadoFilme(){
			//pre condicao: sala existente, filme existente, evento cadastrado
			
			
		}
}
