package br.fenomeno.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.fenomeno.entity.Grupo;
import br.fenomeno.entity.Jogador;

public class GrupoDAO implements IGrupoDAO {

	private DatabaseHelper helper;
	private SQLiteDatabase db;

	public GrupoDAO(Context context) {
		helper = new DatabaseHelper(context);
	}

	private SQLiteDatabase getDb() {
		if (db == null) {
			db = helper.getWritableDatabase();
		}
		return db;
	}

	public void close() {
		helper.close();
		db = null;
	}

	public long salvar(Grupo grupo) {
		ContentValues values = new ContentValues();

		// values.put("id", 1);
		values.put(DatabaseHelper.Grupo.NOME, grupo.getNome());
		values.put(DatabaseHelper.Grupo.DESCRICAO, grupo.getDescricao());
		values.put(DatabaseHelper.Grupo.CONFIG_GOLS, grupo.getConfigGols().toString());
		values.put(DatabaseHelper.Grupo.CONFIG_MINUTOS, grupo.getConfigMinutos().toString());

		return getDb().insert(DatabaseHelper.Grupo.TABELA, null, values);
	}

	public int atualizar(Grupo grupo) {
		ContentValues values = new ContentValues();

		// values.put("id", 1);
		values.put(DatabaseHelper.Grupo.NOME, grupo.getNome());
		values.put(DatabaseHelper.Grupo.DESCRICAO, grupo.getDescricao());
		values.put(DatabaseHelper.Grupo.CONFIG_GOLS, grupo.getConfigGols().toString());
		values.put(DatabaseHelper.Grupo.CONFIG_MINUTOS, grupo.getConfigMinutos().toString());

		String whereClause = DatabaseHelper.Grupo._ID + " = " + grupo.getId();
		return getDb().update(DatabaseHelper.Grupo.TABELA, values, whereClause, null);
	}

	public Grupo buscarGrupo(Grupo g) {

		Cursor cursor = helper.getWritableDatabase().query(DatabaseHelper.Grupo.TABELA, DatabaseHelper.Grupo.COLUNAS,
				DatabaseHelper.Grupo._ID + " = ?", new String[] { g.getId().toString() }, null, null, null);

		if (cursor.moveToNext()) {
			Grupo grupo = criarGrupo(cursor);
			cursor.close();
			return grupo;
		}

		return null;
	}
	
	public List<Grupo> buscarTodosGrupos() {

		Cursor cursor = getDb().query(DatabaseHelper.Grupo.TABELA,
				DatabaseHelper.Grupo.COLUNAS, null, null, null, null, DatabaseHelper.Jogador.NOME);
		List<Grupo> grupos = new ArrayList<Grupo>();
		while(cursor.moveToNext()) {
			Grupo grupo = criarGrupo(cursor);
			grupos.add(grupo);
		}
		cursor.close();
		return grupos;

	}

	private Grupo criarGrupo(Cursor cursor) {
		Grupo grupo = new Grupo(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Grupo._ID)), 
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Grupo.NOME)), 
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Grupo.DESCRICAO)), 
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Grupo.CONFIG_GOLS)), 
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Grupo.CONFIG_MINUTOS)));

		return grupo;
	}

}
