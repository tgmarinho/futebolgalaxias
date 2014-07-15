package br.fenomeno.entity;

import java.util.Date;

public class Partida {

	private Long id;
	private Date inicio;
	private Long jogadorAssistenciaTimeA;
	private Long jogadorGolTimeA;
	private Long jogadorAssistenciaTimeB;
	private Long jogadorGolTimeB;
	
	
	public Partida() { }

	/**
	 *  Construtor usado para criar uma Partida com os resultados do banco
	 * @param id
	 * @param inicio
	 * @param jogadorAssistenciaTimeA
	 * @param jogadorGolTimeA
	 * @param jogadorAssistenciaTimeB
	 * @param jogadorGolTimeB
	 */
	public Partida(Long id, Date inicio, Long jogadorAssistenciaTimeA,
			Long jogadorGolTimeA, Long jogadorAssistenciaTimeB,
			Long jogadorGolTimeB) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.jogadorAssistenciaTimeA = jogadorAssistenciaTimeA;
		this.jogadorGolTimeA = jogadorGolTimeA;
		this.jogadorAssistenciaTimeB = jogadorAssistenciaTimeB;
		this.jogadorGolTimeB = jogadorGolTimeB;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Long getJogadorAssistenciaTimeA() {
		return jogadorAssistenciaTimeA;
	}


	public void setJogadorAssistenciaTimeA(Long jogadorAssistenciaTimeA) {
		this.jogadorAssistenciaTimeA = jogadorAssistenciaTimeA;
	}


	public Long getJogadorGolTimeA() {
		return jogadorGolTimeA;
	}


	public void setJogadorGolTimeA(Long jogadorGolTimeA) {
		this.jogadorGolTimeA = jogadorGolTimeA;
	}


	public Long getJogadorAssistenciaTimeB() {
		return jogadorAssistenciaTimeB;
	}


	public void setJogadorAssistenciaTimeB(Long jogadorAssistenciaTimeB) {
		this.jogadorAssistenciaTimeB = jogadorAssistenciaTimeB;
	}


	public Long getJogadorGolTimeB() {
		return jogadorGolTimeB;
	}


	public void setJogadorGolTimeB(Long jogadorGolTimeB) {
		this.jogadorGolTimeB = jogadorGolTimeB;
	}
	
	
}
