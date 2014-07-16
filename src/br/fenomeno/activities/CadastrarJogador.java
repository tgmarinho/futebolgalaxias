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
import android.widget.TextView;
import br.fenomeno.dao.JogadorDAO;
import br.fenomeno.entity.Jogador;


public class CadastrarJogador extends Activity {
	
	private EditText editTextNome, editTextEmail, editTextTelefone;

    Jogador jogador = new Jogador();
    JogadorDAO jogadorDao = new JogadorDAO(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_jogadores);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		Button cadastrarJogador = (Button) findViewById(R.id.buttonCadastrarJogador);
		
		cadastrarJogador.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				/**
				 * Nome
				 */
				editTextNome = (EditText)findViewById(R.id.editTextNome);
				jogador.setNome(editTextNome.getText().toString());
				
				/**
				 * Email
				 */
				editTextEmail = (EditText)findViewById(R.id.editTextEmail);
				jogador.setEmail(editTextEmail.getText().toString());
				
				/**
				 * Telefone
				 */
				editTextTelefone = (EditText)findViewById(R.id.editTextTelefone);
				jogador.setCelular(editTextTelefone.getText().toString());
				
				jogadorDao.salvar(jogador);
				
				List<Jogador> todosJogadores = new ArrayList<Jogador>();
				todosJogadores = jogadorDao.buscarTodosJogadores();
				
				Intent mudarTela = new Intent(CadastrarJogador.this, Configuracoes.class);
				startActivity(mudarTela);
				
				for(Jogador jog : todosJogadores){
					
					Log.i("Nome", jog.getNome().toString());
				}
				
			}
		});
	}

}
