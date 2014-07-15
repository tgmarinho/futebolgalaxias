package br.fenomeno.service;

import java.util.List;

import android.content.Context;
import br.fenomeno.dao.IJogadorDAO;
import br.fenomeno.dao.JogadorDAO;
import br.fenomeno.entity.Jogador;

public class JogadorService {


	private IJogadorDAO jogadorDao; 

	public JogadorService(Context context) {
		this.jogadorDao = new JogadorDAO(context);
	}

	public String[] arrayDeJogadores() {

		List<Jogador> listaJogadores = jogadorDao.buscarTodosJogadores();

		String[] jogadores = new String[listaJogadores.size()];
		for (int i = 0; i < listaJogadores.size(); i++) {
			jogadores[i] = listaJogadores.get(i).getNome();
		}

		return jogadores;

	}
	
	public List<Jogador> listaDeJogadores() {

		List<Jogador> listaJogadores = jogadorDao.buscarTodosJogadores();

		return listaJogadores;

	}
	

}
