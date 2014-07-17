package br.fenomeno.dao;

import java.util.List;

import br.fenomeno.entity.Partida;

public interface IPartidaDAO {

	public long salvar(Partida partida);
	public long atualizar(Partida partida);
	public boolean excluir(Long id);
	
	public List<Partida> buscarTodasPartidas();
	public Partida buscarPartidaPorId(Long id);
}
