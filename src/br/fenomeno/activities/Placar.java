package br.fenomeno.activities;

import static br.fenomeno.bo.ValidaPlacar.*;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Placar extends Activity implements OnClickListener {

	TextView placarTime1, placarTime2, versus, futeGalaxias;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tela_principal);

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
		// seta padrão
		placarTime1.setText("0");
		placarTime2.setText("0");
		versus.setText("  -  ");

	}

	@Override
	protected void onResume() {
		super.onResume();

		Button btnGolTime1, btnGolTime2, btnDecrementaGolTime1, btnDecrementaGolTime2, btnCronometro;

		btnGolTime1 = (Button) findViewById(R.id.btnFazerGolTime1);
		btnGolTime2 = (Button) findViewById(R.id.btnFazerGolTime2);
		btnDecrementaGolTime1 = (Button) findViewById(R.id.btnTirarGolTime1);
		btnDecrementaGolTime2 = (Button) findViewById(R.id.btnTirarGolTime2);
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
			}
		});

		btnGolTime2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer placarAtual = Integer.parseInt((String) placarTime2.getText());
				placarTime2.setText(String.valueOf(++placarAtual));
			}
		});

		btnDecrementaGolTime1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer placarAtual = Integer.parseInt((String) placarTime1.getText());

				if (!naoPermitePlacarNegativo(placarAtual)) {
					placarTime1.setText(String.valueOf(--placarAtual));
				}
			}

		});

		btnDecrementaGolTime2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Integer placarAtual = Integer.parseInt((String) placarTime2.getText());

				if (!naoPermitePlacarNegativo(placarAtual)) {
					placarTime2.setText(String.valueOf(--placarAtual));

				}
			}
		});

	}

	@Override
	public void onClick(View v) {
		Toast.makeText(this, "Só um minutinho", 3000);
	}

}
