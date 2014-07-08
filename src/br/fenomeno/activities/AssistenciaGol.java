package br.fenomeno.activities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import br.fenomeno.entity.Assistencia;
import br.fenomeno.entity.GerarJogadoresTemp;
import br.fenomeno.entity.Gol;
import br.fenomeno.entity.Jogador;


public class AssistenciaGol extends Activity {

	private int posicaoSpinner;


	List<Assistencia> jogadoresQueFizeramAssistencias = new ArrayList<Assistencia>();
	List<Gol> jogadoresQueFizeramGols = new ArrayList<Gol>();

	// buscar de algum lugar (Banco de dados...)
	List<Jogador> jogadoresFake = GerarJogadoresTemp.jogadoresFake();

	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.spinner_assistencia_gol);

		Typeface type = Typeface.createFromAsset(getAssets(),"fonts/mvboli.ttf");

		TextView txtAssistencia = (TextView) findViewById(R.id.txtAssistencia);
		TextView txtGol = (TextView) findViewById(R.id.txtGol);

		txtAssistencia.setTypeface(type);
		txtGol.setTypeface(type);

		Spinner comboAssistencia = (Spinner) findViewById(R.id.comboAssistencia);
		Spinner comboGol= (Spinner) findViewById(R.id.comboGol);
		final Button btnCartolar = (Button) findViewById(R.id.btnCartolar);

		@SuppressWarnings("rawtypes")
		ArrayAdapter adaptador = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, jogadoresAssistenciaEGol());

		// adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		comboGol.setAdapter(adaptador);

		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		comboAssistencia.setAdapter(adaptador);


		// Se selecionar algum planeta atualiza a imagem
		comboAssistencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {

				//				if (posicao != 0) {
				//				}

				// int pos = posicao;
				setPosicaoSpinner(posicao);
				System.out.println(getPosicaoSpinner());

			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	private String[] jogadoresAssistenciaEGol() {

		
		
		String[] jogadores = new String[] { "Thiago Marinho",
				"Jean Duarte", "Ulisses", "Renato", "Fabio William", "Lucas", "Adaylon" };

		return jogadores;
	}

	public int getPosicaoSpinner() {
		return posicaoSpinner;
	}

	public void setPosicaoSpinner(int posicaoSpinner) {
		this.posicaoSpinner = posicaoSpinner;
	}

}
