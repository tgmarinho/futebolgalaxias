package br.fenomeno.dao;

import java.util.List;

import br.fenomeno.entity.Jogador;


public interface IJogadorDAO {

	public long salvar(Jogador jogador);
	public long editar(Jogador jogador);
	public boolean excluir(Long id);
	public Jogador buscarJogadorPorNome(String nome);
	public List<Jogador> buscarTodosJogadores();
	
	// TODO versão 1.0
	public List<Jogador> buscarJogadoresPorGrupo(Integer idGrupo);
	
}
