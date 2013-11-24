package com.qieventos.dao;

import com.qieventos.persistence.Connection;

public class DAOFactory {
 
	public String RECURSO;
	 
	public String EVENTO;
	 
	public String AGENDA;
	 
	public String TIPOEVENTO;
	 
	private Connection connection;
	 
	 
	public DAO getDAO(String dao) {
		return null;
	}
	 
	public DAOFactory(Connection conn) {
	 
	}
	 
}
 
