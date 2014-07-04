package br.fenomeno.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FutebolGalaxiasSplash extends Activity implements Runnable {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashfutebolgalaxias);

		Handler handler = new Handler();
		handler.postDelayed(this, 3000);
	}
	@Override
	public void run(){
		startActivity(new Intent(this, Placar.class));
		finish();
	}
	
}
