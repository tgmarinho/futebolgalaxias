package br.fenomeno.entity;

/**
 * TODO REFATORAR  vai tornar isso em grupo que já existe, por enquato esta assim para não dar erro na tela, pois não foi implementado o grupo
 * @author jean
 *
 */
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
