package br.fenomeno.entity;

/**
 * Entidade responsavel pelo relacionamento entre o Jogador e o Grupo que ele pertence.
 * @author toliveira
 *
 */
public class GrupoJogador {

	private Integer id;
	private Integer idGrupo;
	private Integer idJogador;
	
	
	public GrupoJogador(Integer id, Integer idGrupo, Integer idJogador) {
		super();
		this.id = id;
		this.idGrupo = idGrupo;
		this.idJogador = idJogador;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	public Integer getIdJogador() {
		return idJogador;
	}
	public void setIdJogador(Integer idJogador) {
		this.idJogador = idJogador;
	}
	
	
	
	
}
