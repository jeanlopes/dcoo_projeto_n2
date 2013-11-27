package com.qieventos.common;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.qieventos.dao.RecursoDAO;
import com.qieventos.models.Recurso;
import com.qieventos.models.RecursoFisico;
import com.qieventos.models.RecursoHumano;

public class TestaRecurso {
	
	private RecursoHumano recursoHumanoBuilder(int idRecurso)
	{
		RecursoHumano recursoHumano = new RecursoHumano();
		recursoHumano.setCPF("03045634530");
		recursoHumano.setDataAdmissao(new Date());
		recursoHumano.setDataNascimento(new Date());
		recursoHumano.setIdRecurso(idRecurso);
		recursoHumano.setValorHora(34);
		return recursoHumano;
	}
	
	private RecursoFisico recursoFisicoBuilder(int idRecurso)
	{
		RecursoFisico recurso = new RecursoFisico();
		recurso.setIdRecurso(idRecurso);
		recurso.setQuantidadeEstoque(123);
		recurso.setValorUtilizado(432);
		return recurso;
	}
	
	private Recurso recursoBuilder()
	{
		Recurso recurso = new Recurso();
		recurso.setNomeRecurso("Carros");
		return recurso;
	}
	

	@Test
	public void testDelete() {
		
		// atribuir valores
		RecursoDAO dao = new RecursoDAO();
		Recurso recurso = recursoBuilder();
		
		// acionar métodos
		dao.setRecurso();
		int id = dao.create(recurso);
		RecursoFisico recursoFisico = recursoFisicoBuilder(id);
		RecursoHumano recursoHumano = recursoHumanoBuilder(id);
		dao.setRecursoHumano();
		int idRecursoFisico = dao.create(recursoHumano);
		dao.setRecursoFisico();
	    int idRecursoHumano = dao.create(recursoFisico);
		
	    
	    dao.delete(idRecursoHumano);
	    dao.setRecursoFisico();
		dao.delete(idRecursoFisico);
		dao.setRecurso();
		dao.delete(id);
		
		// avaliar resultados
		Object r =  dao.read(id);
		Assert.assertNull(r);
		
		dao.setRecursoFisico();
		r = dao.read(idRecursoFisico);
		Assert.assertNull(r);
		
		dao.setRecursoHumano();
		r = dao.read(idRecursoHumano);
		Assert.assertNull(r);
	}

	@Test
	public void testRecursoDAO() {
		
		// atribuir valores
		
		// acionar métodos
				
		// avaliar resultados
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRead() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRecursoFisico() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRecursoHumano() {
		fail("Not yet implemented");
	}

}
