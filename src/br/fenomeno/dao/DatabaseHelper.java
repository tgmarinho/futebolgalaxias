package br.fenomeno.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	private static final String BANCO_DADOS = "FutebolDasGalaxias";
	private static int VERSAO = 14;
	
	/**TODO tirar essa tabela  quando o grupo estiver implementado*/
	public static class Configuracao {
		public static final String TABELA = "Configuracao";
		public static final String _ID = "id";
		public static final String GOL = "gol";
		public static final String MINUTO = "minuto";
		
		public static final String[] COLUNAS = new String[]{ _ID, MINUTO, GOL};
	}
	
	
	public static class Jogador {
		public static final String TABELA = "Jogador";
		public static final String _ID = "_id";
		public static final String NOME = "nome";
		public static final String EMAIL = "email";
		public static final String CELULAR = "celular";
		
		public static final String[] COLUNAS = new String[]{ _ID, NOME, EMAIL, CELULAR};
	}
	
	
	public static class Grupo {
		public static final String TABELA = "Grupo";
		public static final String _ID = "_id";
		public static final String NOME = "nome";
		public static final String DESCRICAO = "descricao";
		public static final String CONFIG_GOLS = "config_qtde_gol";
		public static final String CONFIG_MINUTOS = "config_qtde_min";
		
		public static final String[] COLUNAS = new String[]{ _ID, NOME, DESCRICAO, CONFIG_GOLS, CONFIG_MINUTOS };
	}
	
	
	public static class GrupoJogador {
		public static final String TABELA = "GrupoJogador";
		public static final String _ID = "_id";
		public static final String ID_GRUPO = "id_grupo";
		public static final String ID_JOGADOR = "id_jogador";
		
		public static final String[] COLUNAS = new String[]{ _ID, ID_GRUPO, ID_JOGADOR };
	}
	
	
	
	public static class Partida {
		public static final String TABELA = "Partida";
		public static final String _ID = "_id";
		public static final String INICIO = "dt_inicio";
		public static final String FIM = "dt_fim";
		public static final String GRUPO = "id_grupo";
		
		public static final String[] COLUNAS = new String[]{ _ID, INICIO, FIM, GRUPO };
	}
	
	
	public static class Lance {
		public static final String TABELA = "Lance";
		public static final String _ID = "_id";
		public static final String TEMPO = "tempo";
		public static final String ID_JOGADOR_ASSISTENCIA = "id_jogador_assist";
		public static final String ID_JOGADOR_GOL = "id_jogador_gol";
		public static final String TIME = "time";
		public static final String ID_PARTIDA = "id_partida";
		
		public static final String[] COLUNAS = new String[]{ _ID, TEMPO, ID_JOGADOR_ASSISTENCIA, 
												ID_JOGADOR_GOL, TIME, ID_PARTIDA };
	}
	
	
	
	
	
	public DatabaseHelper(Context context) {
		super(context, BANCO_DADOS, null, VERSAO);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO excluir depois esse cara
		db.execSQL("CREATE TABLE IF NOT EXISTS Configuracao (id INTEGER primary key, gol INTEGER , minutos INTEGER)");
		
		
		db.execSQL("CREATE TABLE IF NOT EXISTS Jogador(_id INTEGER primary key AUTOINCREMENT, nome TEXT, email TEXT, celular TEXT)");
		
		String ddlGrupo = "CREATE TABLE IF NOT EXISTS Grupo(_id INTEGER primary key AUTOINCREMENT, nome TEXT, " +
				 "descricao TEXT, config_qtde_gol INTEGER, config_qtde_min INTEGER ) ";
		db.execSQL(ddlGrupo);
		
		
		db.execSQL("CREATE TABLE IF NOT EXISTS GrupoJogador(_id INTEGER primary key AUTOINCREMENT, id_grupo INTEGER, id_jogador INTEGER ) ");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS Partida(_id INTEGER primary key AUTOINCREMENT, dt_inicio DATE, dt_fim DATE, id_grupo INTEGER )") ;
		
		db.execSQL("CREATE TABLE IF NOT EXISTS Lance(_id INTEGER primary key AUTOINCREMENT, tempo INTEGER, " +
				" id_jogador_assist INTEGER, id_jogador_gol INTEGER, tempo INTEGER, time TEXT )");
		
		
		// TODO excluir depois esse cara
		db.execSQL("INSERT or REPLACE INTO Configuracao (id, gol, minutos) VALUES(1,2,10)");       
		
		// TODO excluir depois esse cara
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (1, 'Thiago Marinho')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (2, 'Adaylon')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (3, 'Igor')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (4, 'Ulisses')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (5, 'Jean')");
		db.execSQL("INSERT OR REPLACE INTO Jogador (_id, nome) VALUES (6, 'Gabriel')");
		
		db.execSQL("INSERT OR REPLACE INTO Grupo (_id, nome, descricao, config_qtde_gol, config_qtde_min) VALUES (1, 'Futebol das Galaxias', 'Galera da AZ', 2, 600)");
		
		db.execSQL("INSERT OR REPLACE INTO GrupoJogador (id_grupo, id_jogador) VALUES (1, 1)");
		db.execSQL("INSERT OR REPLACE INTO GrupoJogador (id_grupo, id_jogador) VALUES (1, 2)");
		db.execSQL("INSERT OR REPLACE INTO GrupoJogador (id_grupo, id_jogador) VALUES (1, 3)");
		db.execSQL("INSERT OR REPLACE INTO GrupoJogador (id_grupo, id_jogador) VALUES (1, 4)");
		
		
		
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS Configuracao");
		db.execSQL("DROP TABLE IF EXISTS Jogador");
		
		this.onCreate(db);
	}
	
}