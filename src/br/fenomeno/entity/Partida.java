package br.fenomeno.entity;

import java.util.Date;

public class Partida {

	private Integer id;
	private Date inicio;
	private Date fim;
	private Integer idGrupo;
	
	
	public Partida() { }


	public Partida(Integer id, Date inicio, Date fim, Integer idGrupo) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.idGrupo = idGrupo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getInicio() {
		return inicio;
	}


	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}


	public Date getFim() {
		return fim;
	}


	public void setFim(Date fim) {
		this.fim = fim;
	}


	public Integer getIdGrupo() {
		return idGrupo;
	}


	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	


}
