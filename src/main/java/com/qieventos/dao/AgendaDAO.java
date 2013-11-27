package com.qieventos.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qieventos.models.Agenda;
import com.qieventos.persistence.Connection;


public class AgendaDAO extends DAO {
 
	public void create(Agenda agenda) {
		try(Connection conn = Connection.getConnection()) {
			 Session s = conn.getSession();
			s.save(agenda);
			s.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	 
	public Agenda read(int id) {
		try (Connection conn = Connection.getConnection()) {
			conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from Evento where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", id);
			Agenda agenda = (Agenda) query.uniqueResult();
			return agenda;
			
		} catch(Exception e) 
		{
			
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	 return null;
	}
	 
	public void update(Agenda agenda) {
		try(Connection conn = Connection.getConnection()) {
			Transaction t = conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from Agenda where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", agenda.getId());
			Agenda updatingAgenda = (Agenda) query.uniqueResult();
			
			updatingAgenda.setDataAgenda(agenda.getDataAgenda());
			updatingAgenda.setHoraFinal(agenda.getHoraFinal());
			updatingAgenda.setHoraInicial(agenda.getHoraInicial());
			
			s.update(updatingAgenda);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	 
	@Override
	public void delete(int id) {
		try(Connection conn = Connection.getConnection()) {
			Transaction t = conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from Agenda where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", id);
			Agenda agenda = (Agenda) query.uniqueResult();
			s.delete(agenda);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	 
}
 
