package com.qieventos.models;

import java.util.Date;

public class Agenda implements java.io.Serializable {
	 
	private static final long serialVersionUID = 1L;

	private int id;
	 
	private Date dataAgenda;
	 
	private Date horaInicial;
	 
	private Date horaFinal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}
	 
}
 
