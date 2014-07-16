package br.fenomeno.dao;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.fenomeno.entity.Partida;

public class PartidaDAO implements IPartidaDAO {

	private DatabaseHelper helper;
	private SQLiteDatabase db;


	public PartidaDAO(Context context){
		helper = new DatabaseHelper(context);
	}

	private SQLiteDatabase getDb() {
		if (db == null) {
			db = helper.getWritableDatabase();
		}
		return db;
	}


	@Override
	public long salvar(Partida p) {
		ContentValues values = new ContentValues();
//		values.put(DatabaseHelper.Partida._ID, p.getId());
//		values.put(DatabaseHelper.Partida._ID_JOGADOR_ASSIST_A, p.getJogadorAssistenciaTimeA());
//		values.put(DatabaseHelper.Partida._ID_JOGADOR_ASSIST_B, p.getJogadorAssistenciaTimeB());
//		values.put(DatabaseHelper.Partida._ID_JOGADOR_GOL_A, p.getJogadorAssistenciaTimeA());
//		values.put(DatabaseHelper.Partida._ID_JOGADOR_GOL_B, p.getJogadorAssistenciaTimeB());
		return getDb().insert(DatabaseHelper.Partida.TABELA, null, values);
	}

	@Override
	public boolean excluir(Long id) {
		String whereClause = DatabaseHelper.Partida._ID + " = ?";
		String[] whereArgs = new String[] { id.toString() };
		int removidos = getDb().delete(DatabaseHelper.Partida.TABELA,
				whereClause, whereArgs);
		return removidos > 0;
	}

	@Override
	public long atualizar(Partida p) {
		ContentValues values = new ContentValues();
//		values.put(DatabaseHelper.Partida._ID, p.getId());
//		values.put(DatabaseHelper.Partida._ID_JOGADOR_ASSIST_A, p.getJogadorAssistenciaTimeA().toString());
//		values.put(DatabaseHelper.Partida._ID_JOGADOR_ASSIST_B, p.getJogadorAssistenciaTimeB().toString());
//		values.put(DatabaseHelper.Partida._ID_JOGADOR_GOL_A, p.getJogadorAssistenciaTimeA().toString());
//		values.put(DatabaseHelper.Partida._ID_JOGADOR_GOL_B, p.getJogadorAssistenciaTimeB().toString());
		return getDb().update(DatabaseHelper.Partida.TABELA, values,
				DatabaseHelper.Partida._ID + " = ?",
				new String[] { p.getId().toString() });
	}



	private Partida criarPartida(Cursor cursor) {
//		Partida partida = new Partida(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Partida._ID)),
//				new Date(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Partida.INICIO))),
//				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Partida._ID_JOGADOR_ASSIST_A)),
//				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Partida._ID_JOGADOR_ASSIST_B)),	
//				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Partida._ID_JOGADOR_GOL_A)),
//				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Partida._ID_JOGADOR_GOL_B))	);

//		return partida;
		return null;
	}




}
