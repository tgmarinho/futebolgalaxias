package br.fenomeno.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.fenomeno.entity.Configuracao;


public class ConfiguracaoDAO implements IConfiguracaoDAO {

	private DatabaseHelper helper;
	private SQLiteDatabase db;


	public ConfiguracaoDAO(Context context){
		helper = new DatabaseHelper(context);
	}

	private SQLiteDatabase getDb() {
		if (db == null) {
			db = helper.getWritableDatabase();
		}
		return db;
	}

	public void close(){
		helper.close();
		db = null;
	}



	public void salvar(Configuracao config) {
		ContentValues values = new ContentValues();

		//values.put("id", 1);
		values.put("gol", config.getGol().toString());
		values.put("minutos", config.getMinutos().toString());

		String where = "id = ?";
		String[] args = {"1"};

		helper.getWritableDatabase().update("Configuracao", values, "id = 1" , null );

		//String strSQL = "UPDATE myTable SET Column1 = someValue WHERE columnId = "+ someValue;
		//myDataBase.execSQL(strSQL);
	}

	public Configuracao buscarConfiguracao() {

		Configuracao config = null;

		String[] colunas = new String[] { "id", "gol", "minutos" };

		Cursor cursor = helper.getWritableDatabase().query("Configuracao", colunas,
				null, null, null, null, null);

		if (cursor != null && cursor.moveToFirst()) {
			config = new Configuracao();
			config.setId(cursor.getInt(cursor.getColumnIndex("id")));
			config.setGol(cursor.getInt(cursor.getColumnIndex("gol")));
			config.setMinutos(cursor.getInt(cursor.getColumnIndex("minutos")));
		}

		if (cursor != null)
			cursor.close();

		return config;

	}



}

