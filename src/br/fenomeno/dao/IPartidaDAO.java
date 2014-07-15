package br.fenomeno.dao;

import br.fenomeno.entity.Partida;

public interface IPartidaDAO {

	public long salvar(Partida partida);
	public long atualizar(Partida partida);
	public boolean excluir(Long id);
	
}
