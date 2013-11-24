package com.qieventos.models;

//extends AbstractBO
public class TipoEvento  implements java.io.Serializable {
	
	public TipoEvento()
	{
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descricao;

	public int getId() {
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	 
}
 
