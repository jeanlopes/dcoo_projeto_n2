package com.qieventos.dao;

public class DAOFactory {
 
	public final char RECURSO = 'R';
	public final char EVENTO = 'E';
	public final char AGENDA = 'A';
	public final char TIPOEVENTO = 'T';
	 
	 
	public DAO getDAO(char dao) throws Exception {
		
		switch (dao) {
		case RECURSO:
			return new RecursoDAO();
		case EVENTO:
			return new EventoDAO();
		case AGENDA:
			return new AgendaDAO();
		case TIPOEVENTO:
			return new TipoEventoDAO();
		default:
			throw new Exception("camada de acesso a dados não existente");
		}
	}
	 
}
 
