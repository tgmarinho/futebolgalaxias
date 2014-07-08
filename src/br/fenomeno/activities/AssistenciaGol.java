package br.fenomeno.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class AssistenciaGol extends Activity {

	private int posicaoSpinner;

	
//	List<Gol> gols = new ArrayList<E>();
//	List<Assistencia> assistencias = new ArrayList<E>();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.spinner_assistencia_gol);

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
