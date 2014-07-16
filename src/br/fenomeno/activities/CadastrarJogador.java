package br.fenomeno.activities;

import br.fenomeno.dao.DatabaseHelper.Jogador;
import br.fenomeno.dao.IJogadorDAO;
import br.fenomeno.dao.JogadorDAO;
import br.fenomeno.entity.Configuracao;
import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;


public class CadastrarJogador extends Activity {
	
	private TextView textViewNome;

    Jogador jogador = new Jogador();
    JogadorDAO jogadorDao = new JogadorDAO(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_jogadores);

		/**
		 * SELECIONAR QTD DE GOLS
		 */
		textViewNome = (TextView)findViewById(R.id.textViewNome);
		//jogador.
        

	}

}
