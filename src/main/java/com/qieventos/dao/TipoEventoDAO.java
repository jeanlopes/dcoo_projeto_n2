package com.qieventos.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qieventos.models.TipoEvento;
import com.qieventos.persistence.Connection;


public class TipoEventoDAO extends DAO {
 

	public int create(TipoEvento tipoEvento) {
		try(Connection conn = Connection.getConnection()) {
			 Session s = conn.getSession();
			s.save(tipoEvento);
			s.getTransaction().commit();
			s.flush();
			return tipoEvento.getId();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return 0;
	}
	 
	public TipoEvento read(int id) {
		try (Connection conn = Connection.getConnection()) {
			conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from TipoEvento where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", id);
			TipoEvento tipoEvento = (TipoEvento) query.uniqueResult();
			return tipoEvento;
			
		} catch(Exception e) 
		{
			
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	 return null;
	}
	 
	public int update(TipoEvento tipoEvento) {
		try(Connection conn = Connection.getConnection()) {
			Transaction t = conn.getSession().beginTransaction();
			Session s = conn.getSession();
			String queryString = "from TipoEvento where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", tipoEvento.getId());
			TipoEvento updatingTipoEvento = (TipoEvento) query.uniqueResult();
			updatingTipoEvento.setDescricao(tipoEvento.getDescricao());
			s.update(updatingTipoEvento);
			t.commit();
			s.flush();
			return updatingTipoEvento.getId();
			
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
			String queryString = "from TipoEvento where id = :id";
			Query query = s.createQuery(queryString);
			query.setInteger("id", id);
			TipoEvento tipoEvento = (TipoEvento) query.uniqueResult();
			s.delete(tipoEvento);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	 
}
 
