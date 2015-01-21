package coen2610.lineevasion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Creates the main menu screen for the game. Creates instances of the buttons that will link
 * to the next screen based on which button is pressed.
 */
public class MainMenuView extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        Button playGameButton = (Button)findViewById(R.id.playGame);
        Button optionsButton = (Button)findViewById(R.id.gameOptions);
        
        playGameButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent playGame = new Intent(getApplicationContext(), PlayGameView.class);
				startActivity(playGame);
			}
		});
        
        optionsButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent optionsScreen = new Intent(getApplicationContext(), OptionsView.class);
				startActivity(optionsScreen);
			}
		});
    } 
}


