package br.fenomeno.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe temporária para teste de componente
 * TODO: mover para teste unitário posteriormente
 * @author toliveira
 *
 */
public final class GerarJogadoresTemp {

	 static List<Jogador> jogadores = null;
	
	public static List<Jogador> jogadoresFake() {

		 List<Jogador> jogadores = new ArrayList<Jogador>();
		
		Jogador j1= new Jogador();
		j1.setId(1);
		j1.setNome("Ulisses");
		
		Jogador j2= new Jogador();
		j2.setId(2);
		j2.setNome("Thiago Marinho");
		
		Jogador j3= new Jogador();
		j3.setId(3);
		j3.setNome("Adaylon");
		
		Jogador j4= new Jogador();
		j4.setId(4);
		j4.setNome("Igor");
		
		Jogador j5= new Jogador();
		j5.setId(5);
		j5.setNome("Jean");
		
		Jogador j6= new Jogador();
		j6.setId(6);
		j6.setNome("Renato");
		
		Jogador j7= new Jogador();
		j7.setId(7);
		j7.setNome("Lucas");
		
		Jogador j8= new Jogador();
		j8.setId(8);
		j8.setNome("Gabriel");
		
		jogadores.add(j1);
		jogadores.add(j2);
		jogadores.add(j3);
		jogadores.add(j4);
		jogadores.add(j5);
		jogadores.add(j6);
		jogadores.add(j7);
		jogadores.add(j8);
		
		
		return jogadores;
		
//		return Arrays.asList(j1, j2, j3, j4, j5, j6, j7, j8);
		
	}
	
	
	public static String[] jogadoresStringFake() {
		
		jogadores = jogadoresFake();
		
		String[] joga = new String[jogadores.size()];
		for (int i = 0; i < jogadores.size(); i++) {
			joga[i] = jogadores.get(i).getNome();
		}
		
		return joga;
		
	}
	
	
	


}
