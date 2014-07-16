package br.fenomeno.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.fenomeno.entity.Jogador;

public class JogadorDAO implements IJogadorDAO {

	private DatabaseHelper helper;
	private SQLiteDatabase db;

	public JogadorDAO(Context context) {
		helper = new DatabaseHelper(context);
	}

	private SQLiteDatabase getDb() {
		if (db == null) {
			db = helper.getWritableDatabase();
		}
		return db;
	}

	@Override
	public long salvar(Jogador j) {
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.Jogador.NOME, j.getNome());
		values.put(DatabaseHelper.Jogador.EMAIL, j.getEmail());
		values.put(DatabaseHelper.Jogador.CELULAR, j.getCelular());
		return getDb().insert(DatabaseHelper.Jogador.TABELA, null, values);
	}

	@Override
	public boolean excluir(Long id) {
		String whereClause = DatabaseHelper.Jogador._ID + " = ?";
		String[] whereArgs = new String[] { id.toString() };
		int removidos = getDb().delete(DatabaseHelper.Jogador.TABELA,
				whereClause, whereArgs);
		return removidos > 0;
	}

	@Override
	public long editar(Jogador j) {
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.Jogador.NOME, j.getNome());
		values.put(DatabaseHelper.Jogador.EMAIL, j.getEmail());
		values.put(DatabaseHelper.Jogador.CELULAR, j.getCelular());
		return getDb().update(DatabaseHelper.Jogador.TABELA, values,
				DatabaseHelper.Jogador._ID + " = ?",
				new String[] { j.getId().toString() });
	}

	@Override
	public Jogador buscarJogadorPorNome(String nome) {

		Cursor cursor = getDb().query(DatabaseHelper.Jogador.TABELA,
				DatabaseHelper.Jogador.COLUNAS,
				DatabaseHelper.Jogador.NOME + " = ?", new String[] { nome },
				null, null, null);
		if (cursor.moveToNext()) {
			Jogador jogador = criarJogador(cursor);
			cursor.close();
			return jogador;
		}
		return null;

	}

	private Jogador criarJogador(Cursor cursor) {
		Jogador jogador = new Jogador(cursor.getInt(cursor .getColumnIndex(DatabaseHelper.Jogador._ID)),
							cursor.getString(cursor.getColumnIndex(DatabaseHelper.Jogador.NOME)),
							cursor.getString(cursor.getColumnIndex(DatabaseHelper.Jogador.EMAIL)),	
							cursor.getString(cursor.getColumnIndex(DatabaseHelper.Jogador.CELULAR))	);
		
		return jogador;
	}

	@Override
	public List<Jogador> buscarTodosJogadores() {

		Cursor cursor = getDb().query(DatabaseHelper.Jogador.TABELA,
				DatabaseHelper.Jogador.COLUNAS, null, null, null, null, DatabaseHelper.Jogador.NOME);
		List<Jogador> jogadores = new ArrayList<Jogador>();
		while(cursor.moveToNext()) {
			Jogador jogador = criarJogador(cursor);
			jogadores.add(jogador);
		}
		cursor.close();
		return jogadores;

	}

	@Override
	public List<Jogador> buscarJogadoresPorGrupo(Integer idGrupo) {
		throw new AssertionError("Método não implementado nessa versão");
	}

}
