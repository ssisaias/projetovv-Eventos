package br.projetovv.test;

import java.util.List;


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

import br.projetovv.dao.ISalaDAO;
import br.projetovv.modelo.Sala;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-context.xml"})
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalaDAOTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	
	@Autowired
	private ISalaDAO sDAO;
	
	@Test
	public void inserirTest() {
		Sala s = new Sala();
		s.setNome("SALA3");
		s.setTipoSala("3D");
		s.setnAcentos(50);
		
		sDAO.inserir(s);
		
		Sala sTest = sDAO.recuperar(1L);
		
		Assert.assertNotNull(sTest);
		
	}
	
	@Test
	public void buscarTest() {
		Sala s = sDAO.buscar("SALA1");
		
		Assert.assertNotNull(s);
	}
	
	@Test
	public void alterarTest() {
		Sala sTest = sDAO.recuperar(1L);
		sTest.setNome("SALA2");
		
		sDAO.alterar(sTest);
		Sala sTest2 = sDAO.recuperar(1L);
		
		Assert.assertNotNull(sTest2);
	}
	
	@Test
	public void recuperarTest() {
		Sala s = sDAO.recuperar(1L);
		
		Assert.assertNotNull(s);
	}
	
	@Test
	public void listarTest() {
		List<Sala> sList = sDAO.listar();
		
		Assert.assertNotNull(sList.get(0));
	}
	
	@Test
	public void removerTest() {
		sDAO.remover(1L);
		Sala s = sDAO.recuperar(1L);
		
		Assert.assertNull(s);
		
	}
	
}
