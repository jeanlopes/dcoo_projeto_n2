package com.qieventos.models;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qieventos.dao.AbstractRecursoStrategy;
import com.qieventos.persistence.Connection;

public class RecursoFisico extends AbstractRecursoStrategy {
 
	private int id;
	 
	private int idRecurso;
	 
	private double valorUtilizado;
	 
	private int quantidadeEstoque;
	 
	private Recurso recurso;

	@Override
	public int create(Object recurso) {
		
		RecursoFisico rec = (RecursoFisico)recurso;
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
		RecursoFisico rec = (RecursoFisico)recurso;
		try(Connection conn = Connection.getConnection()) {
			Transaction t = conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from RecursoFisico where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", rec.getId());
			RecursoFisico updatingRec = (RecursoFisico) query.uniqueResult();
			
			updatingRec.setIdRecurso(rec.getIdRecurso());
			updatingRec.setQuantidadeEstoque(rec.getQuantidadeEstoque());
			updatingRec.setValorUtilizado(rec.getValorUtilizado());
			updatingRec.setRecurso(rec.getRecurso());
			
			s.update(updatingRec);
			t.commit();
			s.flush();
			return updatingRec.getId();
			
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

	public int getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	public double getValorUtilizado() {
		return valorUtilizado;
	}

	public void setValorUtilizado(double valorUtilizado) {
		this.valorUtilizado = valorUtilizado;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	 
}
 
