package br.fenomeno.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import br.fenomeno.entity.Configuracao;

public class ConfiguracaoDAO extends SQLiteOpenHelper {

	private static final String DATABASE = "FutebolDasGalaxias";
	private static final int VERSAO = 8;

	public ConfiguracaoDAO(Context context) {
		super(context, DATABASE, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String ddl = "CREATE TABLE IF NOT EXISTS Configuracao (id INTEGER primary key, gol INTEGER , minutos INTEGER)";
		db.execSQL(ddl);
		
		ddl = "INSERT or replace INTO Configuracao (id, gol, minutos) VALUES(1,2,10)" ;       
		db.execSQL(ddl);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String ddl = "DROP TABLE IF EXISTS Configuracao";
		db.execSQL(ddl);
		
		this.onCreate(db);
	}
	
	public void salvar(Configuracao config) {
		ContentValues values = new ContentValues();
		
		//values.put("id", 1);
		values.put("gol", config.getGol().toString());
		values.put("minutos", config.getMinutos().toString());
		
		String where = "id = ?";
		String[] args = {"1"};
		
		getWritableDatabase().update("Configuracao", values, "id = 1" , null );
		
		//String strSQL = "UPDATE myTable SET Column1 = someValue WHERE columnId = "+ someValue;
		//myDataBase.execSQL(strSQL);
	}

	public Configuracao buscarConfiguracao() {

		Configuracao config = null;

		String[] colunas = new String[] { "id", "gol", "minutos" };

		Cursor cursor = getWritableDatabase().query("Configuracao", colunas,
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
