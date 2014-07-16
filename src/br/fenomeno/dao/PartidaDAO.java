package br.fenomeno.dao;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.fenomeno.entity.Partida;

/**
 *  
 * @author toliveira
 *
 */
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
		values.put(DatabaseHelper.Partida.INICIO, p.getInicio() == null ? null : p.getInicio().getTime());
		values.put(DatabaseHelper.Partida.FIM, p.getFim() == null ? null : p.getFim().getTime());
		values.put(DatabaseHelper.Partida.GRUPO, p.getIdGrupo());
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
		values.put(DatabaseHelper.Partida.INICIO, p.getInicio() == null ? null : p.getInicio().getTime());
		values.put(DatabaseHelper.Partida.FIM, p.getFim() == null ? null : p.getFim().getTime());
		values.put(DatabaseHelper.Partida.GRUPO, p.getIdGrupo());
		return getDb().update(DatabaseHelper.Partida.TABELA, values,
				DatabaseHelper.Partida._ID + " = ?",
				new String[] { p.getId().toString() });
	}



	private Partida criarPartida(Cursor cursor) {
		Partida partida = new Partida(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Partida._ID)),
				new Date(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Partida.INICIO))),
				new Date(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Partida.FIM))),
				cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Partida.GRUPO)));

		return partida;
	}



}
