package coen2610.lineevasion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultyView extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        
        Button easyButton = (Button)findViewById(R.id.easyButton);
        Button normalButton = (Button)findViewById(R.id.normalButton);
        Button hardButton = (Button)findViewById(R.id.hardButton);
        
        easyButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent playGameScreen = new Intent(getApplicationContext(), PlayGameView.class);
				playGameScreen.putExtra("difficulty", "easy");
				startActivity(playGameScreen);
			}
		});
        
		normalButton.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				Intent playGameScreen = new Intent(getApplicationContext(), PlayGameView.class);
				playGameScreen.putExtra("difficulty", "normal");
				startActivity(playGameScreen);
			}
		});
		
		hardButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent playGameScreen = new Intent(getApplicationContext(), PlayGameView.class);
				playGameScreen.putExtra("difficulty", "hard");
				startActivity(playGameScreen);
			}
		});
    }
}
