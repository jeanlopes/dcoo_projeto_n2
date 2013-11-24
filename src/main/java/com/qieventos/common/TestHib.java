package com.qieventos.common;

import com.qieventos.models.TipoEvento;
import com.qieventos.persistence.Connection;




public class TestHib {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Maven + hibernate + mysql");
		
		try (Connection conn = Connection.getConnection()) {
			
			conn.getSession().beginTransaction();
			TipoEvento tipo = new TipoEvento();
			tipo.setDescricao("bla bla bla");
			
			conn.getSession().save(tipo);
			conn.getSession().getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}

	}

}
