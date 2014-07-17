package br.fenomeno.activities;

import static br.fenomeno.bo.ValidaPlacar.naoPermitePlacarNegativo;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;
import br.fenomeno.entity.Partida;
import br.fenomeno.service.PartidaService;

public class Placar extends Activity  {

	private PartidaService partidaService = new PartidaService(this);
	
	private AlertDialog alerta;
	
	TextView txtPlacarTime1, txtPlacarTime2, txtVersus, txtFuteGalaxias;
	
	// Entidade
	Partida partida;
	
	private Intent intent;
	private Chronometer chronometer;
	private long milliseconds;
	Button btnTerminar,btnComecarPausar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tela_principal);
		chronometer = (Chronometer) findViewById(R.id.chronometer);
		milliseconds = 0;
		btnTerminar = (Button) findViewById(R.id.btnTerminar);
		btnComecarPausar = (Button) findViewById(R.id.btnComecar);
		
		Typeface type = Typeface.createFromAsset(getAssets(),"fonts/jd_led3.ttf");
		Typeface type2 = Typeface.createFromAsset(getAssets(),"fonts/jd_wave.ttf");

		txtPlacarTime1 = (TextView) findViewById(R.id.placarTime1);
		txtPlacarTime2 = (TextView) findViewById(R.id.placarTime2);
		txtVersus = (TextView) findViewById(R.id.versus);
		txtFuteGalaxias = (TextView) findViewById(R.id.futeGalaxias);

		txtPlacarTime1.setTypeface(type);
		txtPlacarTime2.setTypeface(type);
		txtVersus.setTypeface(type);
		txtFuteGalaxias.setTypeface(type2);
		// seta padrão
		txtPlacarTime1.setText("0");
		txtPlacarTime2.setText("0");
		txtVersus.setText("  -  ");
		
		partida = new Partida();
		partida.setInicio(new Date());
		partida.setIdGrupo(1); // grupo fake - futuramente pegar do spinner
		partida = partidaService.salvarPartida(partida);
		System.out.println(partida.getId());
		
		Partida partida2 = partidaService.buscarPartidaPorId(partida.getId());
		System.out.println(partida2.toString());
//		
//		List<Partida> partidas = partidaService.buscarTodasPartidas();
//		for (Partida partidateste : partidas) {
//			System.out.println(partidateste.toString());
//		}
		
		this.onResume();
	
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

		btnGolTime1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Integer placarAtual = Integer.parseInt((String) txtPlacarTime1.getText());
				txtPlacarTime1.setText(String.valueOf(++placarAtual));
				
				Intent marcarAssistenciaGol = new Intent(Placar.this, AssistenciaGol.class);
				marcarAssistenciaGol.putExtra("idPartida", partida.getId());
				startActivity(marcarAssistenciaGol);
				
			}
		});

		btnGolTime2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer placarAtual = Integer.parseInt((String) txtPlacarTime2.getText());
				txtPlacarTime2.setText(String.valueOf(++placarAtual));
				
				Intent marcarAssistenciaGol = new Intent(Placar.this, AssistenciaGol.class);
				startActivity(marcarAssistenciaGol);
			}
		});

		btnDecrementaGolTime1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer placarAtual = Integer.parseInt((String) txtPlacarTime1.getText());

				if (!naoPermitePlacarNegativo(placarAtual)) {
					txtPlacarTime1.setText(String.valueOf(--placarAtual));
					// Deleta o Gol do cara
					
				}
				
				
			}

		});

		btnDecrementaGolTime2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer placarAtual = Integer.parseInt((String) txtPlacarTime2.getText());

				if (!naoPermitePlacarNegativo(placarAtual)) {
					txtPlacarTime2.setText(String.valueOf(--placarAtual));
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

	
	private long tempAtual = 0;
	public void startCronometer(View view) {
		
		if (btnComecarPausar.getText().equals("Pausar")){
			tempAtual = SystemClock.elapsedRealtime() - chronometer.getBase();
			chronometer.stop();
			btnComecarPausar.setText("Continuar");
		} 
		else if(btnComecarPausar.getText().equals("Continuar")){
			chronometer.setBase(SystemClock.elapsedRealtime() - tempAtual);
			chronometer.start();
			btnComecarPausar.setText("Pausar");
		}
		
		else {
			
			chronometer.setBase(SystemClock.elapsedRealtime());
			chronometer.start();
			btnComecarPausar.setText("Pausar");
			
		}
	}

	public void terminarPartida(View view) {

		//Cria o gerador do AlertDialog
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		//define o titulo
		builder.setTitle("Terminar Partida");
		//define a mensagem
		builder.setMessage("Deseja terminar a Partida");
		//define um botão como positivo
		builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {

				chronometer.setBase(SystemClock.elapsedRealtime());
				chronometer.stop();
				btnComecarPausar.setText("Começar");

				
				partida.setFim(new Date());
				partidaService.atualizar(partida);
				System.out.println(partida.toString());
				onCreate(new Bundle());

				Toast.makeText(Placar.this, "Partida de número: " + partida.getId() + ", salva com sucesso!", Toast.LENGTH_SHORT).show();
			}
		});

		builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				Toast.makeText(Placar.this, "Voltando para partida atual", Toast.LENGTH_SHORT).show();
			}
		});
		//cria o AlertDialog
		alerta = builder.create();
		//Exibe
		alerta.show();


	}
	
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	
}
