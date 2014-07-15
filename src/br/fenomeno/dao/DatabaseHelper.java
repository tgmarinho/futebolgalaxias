package br.fenomeno.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	private static final String BANCO_DADOS = "FutebolDasGalaxias";
	private static int VERSAO = 8;
	
	
	public static class Configuracao{
		public static final String TABELA = "configuracao";
		public static final String _ID = "_id";
		public static final String GOL = "gol";
		public static final String MINUTO = "minuto";
		
		public static final String[] COLUNAS = new String[]{ _ID, MINUTO, GOL};
	}
	
	
	public static class Partida{
		public static final String TABELA = "partida";
		public static final String _ID = "_id";
		public static final String QTDE_GOL_TIME_A = "qtde_gol_time_a";
		public static final String QTDE_GOL_TIME_B = "qtde_gol_time_b";
		
		public static final String[] COLUNAS = new String[]{ _ID, QTDE_GOL_TIME_A, QTDE_GOL_TIME_B};
	}
	
	public static class Jogador{
		public static final String TABELA = "jogador";
		public static final String _ID = "_id";
		public static final String NOME = "nome";
		public static final String EMAIL = "email";
		public static final String CELULAR = "celular";
		
		public static final String[] COLUNAS = new String[]{ _ID, NOME, EMAIL, CELULAR};
	}
	
	public static class AssistenciaGol{
		public static final String TABELA = "assistencia_gol";
		public static final String _ID = "_id";
		public static final String _ID_PARTIDA = "id_partida";
		public static final String _ID_JOGADOR_ASSIST_A = "id_jogador_assist_a";
		public static final String _ID_JOGADOR_ASSIST_B = "id_jogador_assist_b";
		public static final String _ID_JOGADOR_GOL_A = "id_jogador_gol_a";
		public static final String _ID_JOGADOR_GOL_B = "id_jogador_gol_b";
		
		public static final String[] COLUNAS = new String[]{ _ID, _ID_PARTIDA,
				_ID_JOGADOR_ASSIST_A, _ID_JOGADOR_ASSIST_B, _ID_JOGADOR_GOL_A, _ID_JOGADOR_GOL_B };
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
	
}