package com.qieventos.models;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qieventos.dao.AbstractRecursoStrategy;
import com.qieventos.persistence.Connection;

public class RecursoHumano extends AbstractRecursoStrategy {
 
	private int id;
	 
	private int idRecurso;
	 
	private Date dataNascimento;
	 
	private double valorHora;
	 
	private String CPF;
	 
	private Date dataAdmissao;
	 
	private Recurso recurso;

	@Override
	public int create(Object recurso) {
		RecursoHumano rec = (RecursoHumano)recurso;
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
		RecursoHumano rec = (RecursoHumano)recurso;
		try(Connection conn = Connection.getConnection()) {
			Transaction t = conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from RecursoHumano where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", rec.getId());
			RecursoHumano updatingRec = (RecursoHumano) query.uniqueResult();
			
			updatingRec.setCPF(rec.getCPF());
			updatingRec.setDataAdmissao(rec.getDataAdmissao());
			updatingRec.setDataNascimento(rec.getDataNascimento());
			updatingRec.setIdRecurso(rec.getIdRecurso());
			updatingRec.setRecurso(rec.getRecurso());
			updatingRec.setValorHora(rec.getValorHora());
			
			
			s.update(updatingRec);
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

	public int getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	 
}
 
