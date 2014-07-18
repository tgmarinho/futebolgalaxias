package br.fenomeno.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import br.fenomeno.dao.GrupoDAO;
import br.fenomeno.entity.Configuracao;
import br.fenomeno.entity.Grupo;
import br.fenomeno.entity.Jogador;

public class CadastroGruposActivity extends Activity implements OnSeekBarChangeListener {

	private EditText editTextNome, editTextDescricao;

	// private TimePicker tempoDeJogo;
	private SeekBar seekBarGols, seekBarTempo;
	private TextView textProgressGols, textProgressTempo;
	GrupoDAO grupoDao = new GrupoDAO(this);
	Grupo grupo = new Grupo();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_grupos);

		/**
		 * VALORES DEFAULT
		 */
		// grupo = grupoDao.buscarGrupo();
		grupo.setConfigGols(2);
		grupo.setConfigMinutos(10);

		/**
		 * SELECIONAR QTD DE GOLS
		 */
		seekBarGols = (SeekBar) findViewById(R.id.seekBarGols);
		seekBarGols.setOnSeekBarChangeListener(this);

		textProgressGols = (TextView) findViewById(R.id.textViewProgressGols);

		seekBarGols.setProgress(grupo.getConfigGols());
		textProgressGols.setText("Quantidade selecionada: " + seekBarGols.getProgress() + " gol(s)");

		/**
		 * SELECIONAR TEMPO
		 */
		seekBarTempo = (SeekBar) findViewById(R.id.seekBarTempo);
		seekBarTempo.setOnSeekBarChangeListener(this);

		textProgressTempo = (TextView) findViewById(R.id.textViewProgressTempo);

		seekBarTempo.setProgress(grupo.getConfigMinutos());
		textProgressTempo.setText("Tempo selecionado:  " + seekBarTempo.getProgress() + "min");

		/**
		 * SETAR NA ENTIDADE GRUPO
		 */
		// Gol
		grupo.setConfigGols(seekBarGols.getProgress());
		// Tempo de Jogo
		grupo.setConfigMinutos(seekBarTempo.getProgress());

		/**
		 * SALVAR NO BANCO
		 */
		//grupoDao.salvar(grupo);
		//grupoDao.close();
	}

	@Override
	protected void onResume() {
		super.onResume();
		
Button cadastrarGrupos = (Button) findViewById(R.id.btnCadastrarGrupo);
		
		cadastrarGrupos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				/**
				 * Nome
				 */
				editTextNome = (EditText)findViewById(R.id.editTextGrupoNome);
				grupo.setNome(editTextNome.getText().toString());
				
				/**
				 * Descricao
				 */
				editTextDescricao = (EditText)findViewById(R.id.editTextGrupoDescricao);
				grupo.setDescricao(editTextDescricao.getText().toString());
				
				/**
				 * SALVAR NO BANCO
				 */
				grupoDao.salvar(grupo);
				grupoDao.close();
				
				//EXCLUIR DEPOIS
				List<Grupo> todosGrupos = new ArrayList<Grupo>();
				todosGrupos = grupoDao.buscarTodosGrupos();
				
				for (Grupo grupoTeste : todosGrupos) {
					Log.i("GRUPO: ", grupoTeste.toString());
				}
				//FIM EXCLUIR
				
				Intent mudarTela = new Intent(CadastroGruposActivity.this, Placar.class);
				mudarTela.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(mudarTela);				
			}
		});
		
		

		LinearLayout configCadastrarJogador = (LinearLayout) findViewById(R.id.configCadastrarJogador);

		configCadastrarJogador.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent marcarAssistenciaGol = new Intent(CadastroGruposActivity.this, CadastroJogadoresActivity.class);
				startActivity(marcarAssistenciaGol);

			}
		});
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

		if (seekBar.getId() == (seekBarGols.getId())) {
			textProgressGols.setText("Quantidade selecionada: " + progress + " gol(s)");
		} else if (seekBar.getId() == (seekBarTempo.getId())) {
			textProgressTempo.setText("Tempo selecionado: " + progress + "min");
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// textAction.setText("iniciando seleção..");
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		seekBar.setSecondaryProgress(seekBar.getProgress());

		if (seekBar.getId() == (seekBarGols.getId())) {
			grupo.setConfigGols(seekBar.getProgress());
		} else if (seekBar.getId() == (seekBarTempo.getId())) {
			grupo.setConfigMinutos(seekBar.getProgress());
		}
	}
}
