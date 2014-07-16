package br.fenomeno.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	private static final String BANCO_DADOS = "FutebolDasGalaxias";
	private static int VERSAO = 14;
	
	
	public static class Configuracao{
		public static final String TABELA = "Configuracao";
		public static final String _ID = "id";
		public static final String GOL = "gol";
		public static final String MINUTO = "minuto";
		
		public static final String[] COLUNAS = new String[]{ _ID, MINUTO, GOL};
	}
	
	
	public static class Partida{
		public static final String TABELA = "Partida";
		public static final String _ID = "_id";
		public static final String INICIO = "dt_inicio";
		public static final String _ID_JOGADOR_ASSIST_A = "id_jogador_assist_a";
		public static final String _ID_JOGADOR_ASSIST_B = "id_jogador_assist_b";
		public static final String _ID_JOGADOR_GOL_A = "id_jogador_gol_a";
		public static final String _ID_JOGADOR_GOL_B = "id_jogador_gol_b";
		
		public static final String[] COLUNAS = new String[]{ _ID, INICIO, _ID_JOGADOR_ASSIST_A, 
			_ID_JOGADOR_ASSIST_B, _ID_JOGADOR_GOL_A, _ID_JOGADOR_GOL_B };
	}
	
	public static class Jogador{
		public static final String TABELA = "Jogador";
		public static final String _ID = "_id";
		public static final String NOME = "nome";
		public static final String EMAIL = "email";
		public static final String CELULAR = "celular";
		
		public static final String[] COLUNAS = new String[]{ _ID, NOME, EMAIL, CELULAR};
	}
	
	public static class Lance{
		public static final String TABELA = "lance";
		public static final String _ID = "_id";
		public static final String _ID_PARTIDA = "id_partida";
		public static final String DESCRICAO = "descricao";
		
		public static final String[] COLUNAS = new String[]{ _ID, _ID_PARTIDA, DESCRICAO };
	}
	
	public DatabaseHelper(Context context) {
		super(context, BANCO_DADOS, null, VERSAO);
	}

//	@Override
//	public void onCreate(SQLiteDatabase db) {
//		
//		
//		
//		
//		db.execSQL("CREATE TABLE viagem (_id INTEGER PRIMARY KEY," +
//					" destino TEXT, tipo_viagem INTEGER, data_chegada DATE," +
//					" data_saida DATE, orcamento DOUBLE, quantidade_pessoas INTEGER);");
//		
//		db.execSQL("CREATE TABLE gasto (_id INTEGER PRIMARY KEY," +
//					" categoria TEXT, data DATE, valor DOUBLE, descricao TEXT," +
//					" local TEXT, viagem_id INTEGER," +
//					" FOREIGN KEY(viagem_id) REFERENCES viagem(_id));");
//		
//		db.execSQL("CREATE TABLE anotacao (_id INTEGER PRIMARY KEY," +
//				   " dia INTEGER, titulo TEXT, descricao TEXT);");
//	}
//
//	@Override
//	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		db.execSQL("DROP TABLE viagem;");
//		db.execSQL("DROP TABLE gasto;");
//		onCreate(db);
//	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("CREATE TABLE IF NOT EXISTS Configuracao (id INTEGER primary key, gol INTEGER , minutos INTEGER)");
		db.execSQL("CREATE TABLE IF NOT EXISTS Jogador(_id INTEGER primary key, nome TEXT, email TEXT, celular TEXT)");
		
		
		db.execSQL("INSERT or REPLACE INTO Configuracao (id, gol, minutos) VALUES(1,2,10)");       
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (1, 'Thiago Marinho')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (2, 'Adaylon')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (3, 'Igor')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (4, 'Ulisses')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (5, 'Jean')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (6, 'Gabriel')");
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS Configuracao");
		db.execSQL("DROP TABLE IF EXISTS Jogador");
		
		this.onCreate(db);
	}
	
}