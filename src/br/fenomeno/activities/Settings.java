package br.fenomeno.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Settings extends Activity implements OnSeekBarChangeListener {
	
	private TimePicker timePicker;
	private SeekBar seekBar;
    private TextView textProgress, textAction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		// SELECIONAR QTD DE GOLS
		seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        
        // make text label for progress value
        textProgress = (TextView)findViewById(R.id.textViewProgress);
        // make text label for action
        textAction = (TextView)findViewById(R.id.textViewAction);
		
		timePicker = (TimePicker) findViewById(R.id.timePicker1);
        timePicker.setIs24HourView(true);
        
       
		/**
		 * SELECIONAR TEMPO
		 */
		Button button = (Button) findViewById(R.id.botaoTimePicker1);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(
						getBaseContext(),
						"Tempo selecionado: " + timePicker.getCurrentHour() + ":"
								+ timePicker.getCurrentMinute(),
						Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	@Override
    public void onProgressChanged(SeekBar seekBar, int progress,
    		boolean fromUser) {
    	// change progress text label with current seekbar value
    	textProgress.setText("Quantidade de Gol(s) \nselecionada: "+progress);
    	// change action text label to changing
    	//textAction.setText("selecionado..");
    }

	@Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    	//textAction.setText("iniciando seleção..");
    }

	@Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    	seekBar.setSecondaryProgress(seekBar.getProgress());
    	//textAction.setText("seleção finalizada");    	
    }

	

}
