package br.fenomeno.entity;

/**
 *  Classe não persitida
 * @author toliveira
 *
 */

public class Gol {

	private Jogador jogador;
	private Integer minuto;
	
	public Gol() {
	}
	
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public Integer getMinuto() {
		return minuto;
	}
	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}
	
}
