package br.fenomeno.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Activity implements OnClickListener {

	
	Button configuracoes ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.settings);
	}
	
	/*@Override
	protected void onResume() {
		super.onResume();
		Log.i("TAG", "BOTAO CLICADOss");
		configuracoes = (Button) findViewById(R.id.configuracoes);
		// TODO Auto-generated method stub
		//super.onCreate(savedInstanceState);		
		//setContentView(R.layout.settings);
		
		configuracoes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Log.i("TAG", "BOTAO CLICADOss");
				//System.out.println("aaaa");
				
				Toast.makeText(Settings.this, "botao clicadooo", Toast.LENGTH_LONG).show();
			}
		});
	}*/
	
	@Override
	public void onClick(View arg0) {
		Toast.makeText(this, "clicado", 3000);
		
	}

	

}
