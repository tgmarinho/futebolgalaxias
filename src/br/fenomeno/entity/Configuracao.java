package br.fenomeno.entity;

import java.sql.Timestamp;

public class Configuracao {

	private Integer gol;
	private Timestamp tempo;
	
	public Integer getGol() {
		return gol;
	}
	public void setGol(Integer gol) {
		this.gol = gol;
	}
	public Timestamp getTempo() {
		return tempo;
	}
	public void setTempo(Timestamp tempo) {
		this.tempo = tempo;
	}
}
