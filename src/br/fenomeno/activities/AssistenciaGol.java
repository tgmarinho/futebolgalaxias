package br.fenomeno.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import br.fenomeno.dao.IJogadorDAO;
import br.fenomeno.dao.JogadorDAO;
import br.fenomeno.entity.Assistencia;
import br.fenomeno.entity.GerarJogadoresTemp;
import br.fenomeno.entity.Gol;
import br.fenomeno.entity.Jogador;
import br.fenomeno.service.JogadorService;


public class AssistenciaGol extends Activity {

	private JogadorService jogadorService = new JogadorService(this);
	
	private int posicaoSpinner;

	List<Assistencia> jogadoresQueFizeramAssistencias = new ArrayList<Assistencia>();
	List<Gol> jogadoresQueFizeramGols = new ArrayList<Gol>();

	// buscar de algum lugar (Banco de dados...)
//	List<Jogador> jogadoresFake =  GerarJogadoresTemp.jogadoresFake();

	private Jogador jogadorAssistencia;
	private Jogador jogadorGol;


	// componentes
	TextView txtAssistencia;
	Spinner comboAssistencia; 
	Spinner comboGol;
	Button btnCartolar;
	TextView txtGol;

	TextView txtQuemFezGol;
	TextView txtQuemFezAssistencia;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner_assistencia_gol);
		
		String[] arrayDeJogadores = jogadorService.arrayDeJogadores();
		
		txtAssistencia = (TextView) findViewById(R.id.txtAssistencia);
		txtGol = (TextView) findViewById(R.id.txtGol);

		comboAssistencia = (Spinner) findViewById(R.id.comboAssistencia);
		comboGol= (Spinner) findViewById(R.id.comboGol);
		btnCartolar = (Button) findViewById(R.id.btnCartolar);


		txtQuemFezGol = (TextView) findViewById(R.id.txtQuemFezGol);;
		txtQuemFezAssistencia = (TextView) findViewById(R.id.txtQuemFezAssistencia);

		@SuppressWarnings("rawtypes")
		ArrayAdapter adaptador = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, arrayDeJogadores);

		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		comboGol.setAdapter(adaptador);

		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		comboAssistencia.setAdapter(adaptador);


	}


	@Override
	protected void onResume() {
		super.onResume();
		
		final List<Jogador> listaDeJogadores = jogadorService.listaDeJogadores();

		// Se selecionar algum planeta atualiza a imagem
		comboAssistencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {

				setJogadorAssistencia(listaDeJogadores.get(posicao));
				setPosicaoSpinner(posicao);
				System.out.println(getJogadorAssistencia().getNome());

			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});


		// Se selecionar algum planeta atualiza a imagem
		comboGol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {

				setJogadorGol(listaDeJogadores.get(posicao));
				setPosicaoSpinner(posicao);
				System.out.println(getJogadorGol().getNome());

			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		btnCartolar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				// Grava 
				txtQuemFezAssistencia.setText("Assitência:" +getJogadorAssistencia().getNome());
				txtQuemFezGol.setText("5' - Gol:" +getJogadorGol().getNome());
				// pegar o minuto que foi feito com o gol ex: 5', 7'
				//acao de gravar o gol e gerar um historico para 
				// gravar no banco de dados

			}
		});
	}


	public int getPosicaoSpinner() {
		return posicaoSpinner;
	}

	public void setPosicaoSpinner(int posicaoSpinner) {
		this.posicaoSpinner = posicaoSpinner;
	}


	public Jogador getJogadorAssistencia() {
		return jogadorAssistencia;
	}


	public void setJogadorAssistencia(Jogador jogadorAssistencia) {
		this.jogadorAssistencia = jogadorAssistencia;
	}


	public Jogador getJogadorGol() {
		return jogadorGol;
	}


	public void setJogadorGol(Jogador jogadorGol) {
		this.jogadorGol = jogadorGol;
	}

}
