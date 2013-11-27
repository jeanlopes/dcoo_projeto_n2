package com.qieventos.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qieventos.models.Recurso;
import com.qieventos.models.RecursoFisico;
import com.qieventos.models.RecursoHumano;
import com.qieventos.persistence.Connection;


public class RecursoDAO extends DAO {
 
	public RecursoDAO() {
		setDefaultStrategy();
	}

	private AbstractRecursoStrategy abstractRecursoStrategy;
	 
	public int create(AbstractRecursoStrategy recurso) {
		return abstractRecursoStrategy.create(recurso);
	}
	 
	public AbstractRecursoStrategy read(int id) {
		try (Connection conn = Connection.getConnection()) {
			conn.getSession().beginTransaction();
			Session s = conn.getSession();			
			String tipoRecurso = abstractRecursoStrategy.getClass().getName();			
			String queryString = "from " + tipoRecurso + " where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", id);
			
			if (abstractRecursoStrategy.getClass().getName().equals("RecursoFisico"))
			{
				RecursoFisico recurso = (RecursoFisico) query.uniqueResult();
				return recurso;
			} else if (abstractRecursoStrategy.getClass().getName().equals("RecursoHumano")) {
				RecursoHumano recurso = (RecursoHumano) query.uniqueResult();
				return recurso;
			} else
			{
				Recurso recurso = (Recurso) query.uniqueResult();
				return recurso;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 
	public int update(AbstractRecursoStrategy recurso) {
		return abstractRecursoStrategy.update(recurso);
	}
	 
	public void delete(int id) {
		try(Connection conn = Connection.getConnection()) {
			Transaction t = conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String tipoRecurso = abstractRecursoStrategy.getClass().getName();			
			String queryString = "from " + tipoRecurso + " where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", id);
			
			if (abstractRecursoStrategy.getClass().getName().equals("RecursoFisico"))
			{
				RecursoFisico recurso = (RecursoFisico) query.uniqueResult();
				s.delete(recurso);
				
			} else if (abstractRecursoStrategy.getClass().getName().equals("RecursoHumano"))
			{
				RecursoHumano recurso = (RecursoHumano) query.uniqueResult();
				s.delete(recurso);
				
			} else
			{
				Recurso recurso = (Recurso) query.uniqueResult();
				s.delete(recurso);
			}
			t.commit();
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	 
	private void setDefaultStrategy() {
		setRecursoFisico();
	}
	
	public void setRecurso() {
		abstractRecursoStrategy = new Recurso();
	}
	 
	public void setRecursoFisico() {
		abstractRecursoStrategy = new RecursoFisico();
	}
	 
	public void setRecursoHumano() {
		abstractRecursoStrategy = new RecursoHumano();
	}
	
}
 
