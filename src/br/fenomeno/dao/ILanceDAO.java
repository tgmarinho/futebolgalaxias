package br.fenomeno.dao;

import br.fenomeno.entity.Lance;

public interface ILanceDAO {

	public long salvar(Lance lance);
	public long atualizar(Lance lance);
	public boolean excluir(Long id);
	
}
