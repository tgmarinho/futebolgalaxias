package br.fenomeno.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import br.fenomeno.dao.ConfiguracaoDAO;
import br.fenomeno.entity.Configuracao;

public class Configuracoes extends Activity implements OnSeekBarChangeListener {
	
	//private TimePicker tempoDeJogo;
	private SeekBar seekBarGols, seekBarTempo;
    private TextView textProgressGols, textProgressTempo;
    ConfiguracaoDAO dao = new ConfiguracaoDAO(this);
    Configuracao config = new Configuracao();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuracoes);
		
		config = dao.buscarConfiguracao();
		
		/**
		 * SELECIONAR QTD DE GOLS
		 */
		seekBarGols = (SeekBar)findViewById(R.id.seekBarGols);
		seekBarGols.setOnSeekBarChangeListener(this);
        
        textProgressGols = (TextView)findViewById(R.id.textViewProgressGols);
        
        seekBarGols.setProgress(config.getGol());
        textProgressGols.setText("Quantidade selecionada: "+seekBarGols.getProgress()+" gol(s)");
		
        /**
         * SELECIONAR TEMPO
         */
        seekBarTempo = (SeekBar)findViewById(R.id.seekBarTempo);
        seekBarTempo.setOnSeekBarChangeListener(this);
        
        textProgressTempo = (TextView)findViewById(R.id.textViewProgressTempo);
        
        seekBarTempo.setProgress(config.getMinutos());
        textProgressTempo.setText("Tempo selecionado:  "+seekBarTempo.getProgress()+"min");
        
		/**
		 * SETAR NA ENTIDADE CONFIGURACAO
		 */
		//Gol
		config.setGol(seekBarGols.getProgress());
		//Tempo de Jogo
		config.setMinutos(seekBarTempo.getProgress());
		
		/**
		 * SALVAR NO BANCO
		 */
		dao.salvar(config);
		dao.close();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		LinearLayout configCadastrarJogador = (LinearLayout) findViewById(R.id.configCadastrarJogador);
		
		configCadastrarJogador.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent marcarAssistenciaGol = new Intent(Configuracoes.this, CadastrarJogador.class);
				startActivity(marcarAssistenciaGol);
				
				
			}
		});
	}
	
	@Override
    public void onProgressChanged(SeekBar seekBar, int progress,
    		boolean fromUser) {
		
		if (seekBar.getId() == (seekBarGols.getId())) {
			textProgressGols.setText("Quantidade selecionada: " + progress
					+ " gol(s)");
		} else if (seekBar.getId() == (seekBarTempo.getId())) {
			textProgressTempo.setText("Tempo selecionado: " + progress + "min");
		}
    }

	@Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    	//textAction.setText("iniciando sele��o..");
    }

	@Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    	seekBar.setSecondaryProgress(seekBar.getProgress());

		if (seekBar.getId() == (seekBarGols.getId())) {
			config.setGol(seekBar.getProgress());
		} else if (seekBar.getId() == (seekBarTempo.getId())) {
			config.setMinutos(seekBar.getProgress());
		}

		/**
		 * SALVAR NO BANCO
		 */
		dao.salvar(config);
		dao.close();
    }
}
