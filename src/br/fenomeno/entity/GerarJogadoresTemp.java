package br.fenomeno.entity;

import java.util.Arrays;
import java.util.List;

public final class GerarJogadoresTemp {

	public static List<Jogador> jogadoresFake() {

		Jogador j1= new Jogador();
		j1.setId(1L);
		j1.setNome("Ulisses");
		
		Jogador j2= new Jogador();
		j1.setId(2L);
		j1.setNome("Thiago Marinho");
		
		Jogador j3= new Jogador();
		j1.setId(3L);
		j1.setNome("Adaylon");
		
		Jogador j4= new Jogador();
		j1.setId(4L);
		j1.setNome("Igor");
		
		Jogador j5= new Jogador();
		j1.setId(5L);
		j1.setNome("Jean");
		
		Jogador j6= new Jogador();
		j1.setId(6L);
		j1.setNome("Renato");
		
		Jogador j7= new Jogador();
		j1.setId(7L);
		j1.setNome("Lucas");
		
		Jogador j8= new Jogador();
		j1.setId(8L);
		j1.setNome("Gabriel");

		return Arrays.asList(j1, j2, j3, j4, j5, j6, j7, j8);
		
	}


}
