package br.fenomeno.dao;

import br.fenomeno.entity.Configuracao;



public interface IConfiguracaoDAO {
	
	public Configuracao buscarConfiguracao();
	
	public void salvar(Configuracao config);
}

