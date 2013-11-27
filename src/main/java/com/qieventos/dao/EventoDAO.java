package com.qieventos.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qieventos.models.Evento;
import com.qieventos.persistence.Connection;


public class EventoDAO extends DAO {
 
	public EventoDAO()
	{
	
	}
	
	public int create(Evento evento) {
		try(Connection conn = Connection.getConnection()) {
			 Session s = conn.getSession();
			s.save(evento);
			s.getTransaction().commit();
			s.flush();
			return evento.getId();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return 0;
	}
	 
	public Evento read(int id) {
	 
		try (Connection conn = Connection.getConnection()) {
			conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from Evento where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", id);
			Evento evento = (Evento) query.uniqueResult();
			return evento;
			
		} catch(Exception e) 
		{
			
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	 return null;
	}
	
	public int update(Evento evento) {
		try(Connection conn = Connection.getConnection()) {
			Transaction t = conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from Evento where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", evento.getId());
			Evento updatingEvento = (Evento) query.uniqueResult();
			
			updatingEvento.setCusto(evento.getCusto());
			updatingEvento.setIdTipoEvento(evento.getIdTipoEvento());
			updatingEvento.setDescricao(evento.getDescricao());
			
			s.update(updatingEvento);
			t.commit();
			s.flush();
			return evento.getId();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return 0;
	}
	 
	public void delete(int id) {
		
		try(Connection conn = Connection.getConnection()) {
			Transaction t = conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from Evento where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", id);
			Evento evento = (Evento) query.uniqueResult();
			s.delete(evento);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	 
}
 
