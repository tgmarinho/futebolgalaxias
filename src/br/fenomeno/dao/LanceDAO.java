package br.fenomeno.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.fenomeno.entity.Lance;

public class LanceDAO implements ILanceDAO {

	
	private DatabaseHelper helper;
	private SQLiteDatabase db;

	public LanceDAO(Context context) {
		helper = new DatabaseHelper(context);
	}

	private SQLiteDatabase getDb() {
		if (db == null) {
			db = helper.getWritableDatabase();
		}
		return db;
	}

	
	@Override
	public long salvar(Lance l) {
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.Lance._ID, l.getId());
		values.put(DatabaseHelper.Lance.ID_JOGADOR_ASSISTENCIA, l.getIdJogadorAssistencia());
		values.put(DatabaseHelper.Lance.ID_JOGADOR_GOL, l.getIdJogadorGol());
		values.put(DatabaseHelper.Lance.ID_PARTIDA, l.getIdPartida());
		values.put(DatabaseHelper.Lance.TEMPO, l.getTempo());
		values.put(DatabaseHelper.Lance.TIME, l.getTime());
		return getDb().insert(DatabaseHelper.Partida.TABELA, null, values);
	}

	@Override
	public boolean excluir(Long id) {
		String whereClause = DatabaseHelper.Partida._ID + " = ?";
		String[] whereArgs = new String[] { id.toString() };
		int removidos = getDb().delete(DatabaseHelper.Lance.TABELA,
				whereClause, whereArgs);
		return removidos > 0;
	}

	@Override
	public long atualizar(Lance l) {
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.Lance._ID, l.getId());
//		values.put(DatabaseHelper.Lance._ID_PARTIDA, l.getIdPartida());
//		values.put(DatabaseHelper.Lance.DESCRICAO, l.getLances());
		return getDb().update(DatabaseHelper.Lance.TABELA, values, DatabaseHelper.Partida._ID + " = ?",
							new String[] { l.getId().toString() });
	}



	private Lance criarLance(Cursor cursor) {
//		Lance lance = new Lance(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Partida._ID)),
//				cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Lance._ID_PARTIDA)),
//				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Lance.DESCRICAO)));

		return new Lance(); //lance;
	}
	
	
}
