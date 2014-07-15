package br.fenomeno.activities;

import static br.fenomeno.bo.ValidaPlacar.*;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class Placar extends Activity implements OnClickListener {

	TextView placarTime1, placarTime2, versus, futeGalaxias;
	
	private Intent intent;
	private Chronometer ch;
	private long milliseconds;
	Button stop,start;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tela_principal);
		ch = (Chronometer) findViewById(R.id.chronometer);
		milliseconds = 0;
		stop = (Button) findViewById(R.id.btnStop);
		start = (Button) findViewById(R.id.btnComecar);
		
		Typeface type = Typeface.createFromAsset(getAssets(),"fonts/jd_led3.ttf");
		Typeface type2 = Typeface.createFromAsset(getAssets(),"fonts/jd_wave.ttf");

		placarTime1 = (TextView) findViewById(R.id.placarTime1);
		placarTime2 = (TextView) findViewById(R.id.placarTime2);
		versus = (TextView) findViewById(R.id.versus);
		futeGalaxias = (TextView) findViewById(R.id.futeGalaxias);

		placarTime1.setTypeface(type);
		placarTime2.setTypeface(type);
		versus.setTypeface(type);
		futeGalaxias.setTypeface(type2);
		// seta padr�o
		placarTime1.setText("0");
		placarTime2.setText("0");
		versus.setText("  -  ");

	}

	@Override
	protected void onResume() {
		super.onResume();

		Button btnGolTime1, btnGolTime2, btnDecrementaGolTime1, btnDecrementaGolTime2,
				btnCronometro, btnConfiguracoes, btnLances;

		btnGolTime1 = (Button) findViewById(R.id.btnFazerGolTime1);
		btnGolTime2 = (Button) findViewById(R.id.btnFazerGolTime2);
		btnDecrementaGolTime1 = (Button) findViewById(R.id.btnTirarGolTime1);
		btnDecrementaGolTime2 = (Button) findViewById(R.id.btnTirarGolTime2);
		btnLances = (Button) findViewById(R.id.btnLances);
		// btnCronometro = (Button) findViewById(R.id.btnJogo);

		// View.OnClickListener mStartListener = new OnClickListener() {
		// public void onClick(View v) {
		// Integer placar = Integer.parseInt(placarTime1.getText().toString());
		// placarTime1.setText(placar++);
		// }
		// };

		btnGolTime1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Integer placarAtual = Integer.parseInt((String) placarTime1.getText());
				placarTime1.setText(String.valueOf(++placarAtual));
				
				Intent marcarAssistenciaGol = new Intent(Placar.this, AssistenciaGol.class);
				startActivity(marcarAssistenciaGol);
				
				
			}
		});

		btnGolTime2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer placarAtual = Integer.parseInt((String) placarTime2.getText());
				placarTime2.setText(String.valueOf(++placarAtual));
				
				Intent marcarAssistenciaGol = new Intent(Placar.this, AssistenciaGol.class);
				startActivity(marcarAssistenciaGol);
			}
		});

		btnDecrementaGolTime1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer placarAtual = Integer.parseInt((String) placarTime1.getText());

				if (!naoPermitePlacarNegativo(placarAtual)) {
					placarTime1.setText(String.valueOf(--placarAtual));
					// Deleta o Gol do cara
					
				}
				
				
			}

		});

		btnDecrementaGolTime2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer placarAtual = Integer.parseInt((String) placarTime2.getText());

				if (!naoPermitePlacarNegativo(placarAtual)) {
					placarTime2.setText(String.valueOf(--placarAtual));
					// Deleta o Gol do cara
				}
				
			}
		});
		
		
		/**
		 * ACESSO AS CONFIGURACOES
		 */
		btnConfiguracoes = (Button) findViewById(R.id.btnConfiguracoes);
		btnConfiguracoes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent irParaSettings = new Intent(Placar.this, Configuracoes.class);
				startActivity(irParaSettings);
			}
		});
		
		
		
		/**
		 * ACESSA OS LANCES ASSISTENCIA E GOLS
		 */

		
		btnLances.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent irParaLances = new Intent(Placar.this, Lances.class);
				startActivity(irParaLances);
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemClicado = item.getItemId();
		
		switch (itemClicado) {
		case R.id.config:
			//Log.i("TAG", "BOTAO CLICADO CASE");
			Intent irParaSettings = new Intent(this, Configuracoes.class);
			startActivity(irParaSettings);
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(this, "Só um minutinho", 3000).show();
	}
	private long tempAtual = 0;
	public void startCronometer(View view) {		
		if (start.getText().equals("Pausar")){
			tempAtual = SystemClock.elapsedRealtime() - ch.getBase();
			ch.stop();
			start.setText("Continuar");
		} 
		else if(start.getText().equals("Continuar")){
//			tempAtual = SystemClock.elapsedRealtime() - tempAtual;
			ch.start();
			start.setText("Pausar");
		}
		
		else {
			ch.setBase(SystemClock.elapsedRealtime());
			ch.start();
			start.setText("Pausar");
		
		}
	}

	public void resetCronometer(View view) {
		ch.setBase(SystemClock.elapsedRealtime());
		ch.stop();
		start.setText("Começar");
	}
	
}
