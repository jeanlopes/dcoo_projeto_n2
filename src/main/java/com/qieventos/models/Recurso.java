package com.qieventos.models;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qieventos.dao.AbstractRecursoStrategy;
import com.qieventos.persistence.Connection;

public class Recurso extends AbstractRecursoStrategy implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nomeRecurso;

	@Override
	public int create(Object recurso) {
		Recurso rec = (Recurso) recurso;
		try(Connection conn = Connection.getConnection()) {
			 Session s = conn.getSession();
			s.save(rec);
			s.getTransaction().commit();
			s.flush();
			return rec.getId();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int update(Object recurso) {
		Recurso rec = (Recurso)recurso;
		try(Connection conn = Connection.getConnection()) {
			Transaction t = conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from TipoEvento where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", rec.getId());
			Recurso updatingTipoEvento = (Recurso) query.uniqueResult();
			rec.setNomeRecurso(rec.getNomeRecurso());
			s.update(updatingTipoEvento);
			t.commit();
			s.flush();
			return rec.getId();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRecurso() {
		return nomeRecurso;
	}

	public void setNomeRecurso(String nomeRecurso) {
		this.nomeRecurso = nomeRecurso;
	}
	
}
 
