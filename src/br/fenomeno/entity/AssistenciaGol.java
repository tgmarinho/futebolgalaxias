package br.fenomeno.entity;

/**
 * Entidade persistente que armazena o id da partida e id do jogador que fez assistencia e gol
 * uma partida pode ter v�rias assistencias e gols.
 * 
 * 
 * @author toliveira
 *
 */

public class AssistenciaGol {

	private Long id;
	private Jogador jogadorAssistenciaTimeA;
	private Jogador jogadorGolTimeA;
	private Jogador jogadorAssistenciaTimeB;
	private Jogador jogadorGolTimeB;
	
	public AssistenciaGol() { }

	
	
	public Jogador getJogadorAssistenciaTimeA() {
		return jogadorAssistenciaTimeA;
	}

	public void setJogadorAssistenciaTimeA(Jogador jogadorAssistenciaTimeA) {
		this.jogadorAssistenciaTimeA = jogadorAssistenciaTimeA;
	}

	public Jogador getJogadorGolTimeA() {
		return jogadorGolTimeA;
	}

	public void setJogadorGolTimeA(Jogador jogadorGolTimeA) {
		this.jogadorGolTimeA = jogadorGolTimeA;
	}

	public Jogador getJogadorAssistenciaTimeB() {
		return jogadorAssistenciaTimeB;
	}

	public void setJogadorAssistenciaTimeB(Jogador jogadorAssistenciaTimeB) {
		this.jogadorAssistenciaTimeB = jogadorAssistenciaTimeB;
	}

	public Jogador getJogadorGolTimeB() {
		return jogadorGolTimeB;
	}

	public void setJogadorGolTimeB(Jogador jogadorGolTimeB) {
		this.jogadorGolTimeB = jogadorGolTimeB;
	}

	public Long getId() {
		return id;
	}
	
	
}
