package br.fenomeno.entity;

import java.sql.Timestamp;

import android.widget.TimePicker;

public class Configuracao {

	private Integer id;
	private Integer gol;
	private Integer minutos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGol() {
		return gol;
	}
	public void setGol(Integer gol) {
		this.gol = gol;
	}
	public Integer getMinutos() {
		return minutos;
	}
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}
}
