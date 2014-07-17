package br.fenomeno.service;

import java.util.List;

import android.content.Context;
import br.fenomeno.dao.IPartidaDAO;
import br.fenomeno.dao.PartidaDAO;
import br.fenomeno.entity.Partida;

public class PartidaService {

	
	private IPartidaDAO partidaDao; 

	public PartidaService(Context context) {
		this.partidaDao = new PartidaDAO(context);
	}
	
	public Partida salvarPartida(Partida partida) {
		
		long idPartida = partidaDao.salvar(partida);
		return partidaDao.buscarPartidaPorId(idPartida);
		
		
	}

	public Partida buscarPartidaPorId(Long id) {
		
		return partidaDao.buscarPartidaPorId(id);
		
	}

	public List<Partida> buscarTodasPartidas() {
		 return partidaDao.buscarTodasPartidas();
	}

	public Partida atualizar(Partida partida) {
		long idPartida = partidaDao.atualizar(partida);
		return partidaDao.buscarPartidaPorId(idPartida);
	}

	
}
