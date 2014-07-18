package br.fenomeno.dao;

import br.fenomeno.entity.Grupo;



public interface IGrupoDAO {
	
	public Grupo buscarGrupo(Grupo grupo);
	
	public long salvar(Grupo grupo);
}

