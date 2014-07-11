package br.fenomeno.activities;



import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lances extends ListActivity {

	private String[] lstEstados;

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		//Criar um array de Strings, que será utilizado em seu ListActivity
		lstEstados = new String[] {"São Paulo", "Rio de Janeiro", "Minas Gerais", "Rio Grande do Sul",
				"Santa Catarina", "Paraná", "Mato Grosso", "Amazonas"};
		
//		List<Object> estados = new ArrayList<Object>();
//		estados.add("São Paulo");
//		estados.add("Rio de Janeiro");
//		estados.add("Minas Gerais");
//		estados.add("Rio Grande do Sul");
//		estados.add("Santa Catarina");
//		estados.add("Paraná");
//		estados.add("Amazonas");
		

		//Criar um ArrayAdapter, que vai fazer aparecer as Strings acima em seu ListView
		this.setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, lstEstados));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		//Pegar o item clicado
		Object o = this.getListAdapter().getItem(position);
		String lstrEstado = o.toString();

		//Apresentar o item clicado
		Toast.makeText(this, "Você clicou no estado : " + lstrEstado, Toast.LENGTH_LONG).show();
	}
}


