package br.fenomeno.service;

import android.content.Context;
import br.fenomeno.dao.IPartidaDAO;
import br.fenomeno.dao.PartidaDAO;
import br.fenomeno.entity.Partida;

public class PartidaService {

	
	private IPartidaDAO partidaDao; 

	public PartidaService(Context context) {
		this.partidaDao = new PartidaDAO(context);
	}
	
	public long salvarPartida(Partida partida) {
		
		return partidaDao.salvar(partida);
		
	}

	
}
