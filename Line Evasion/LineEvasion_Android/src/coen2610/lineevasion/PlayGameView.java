package coen2610.lineevasion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class PlayGameView extends Activity {

	public static final String DIFFICULTY = "coen2610.lineevasion.PlayGameView.THIS_DIFFICULTY";
	public static final String GRAPHICS_SET = "coen2610.lineevasion.PlayGameView.GRAPHICS_SET";	
	public int width;
	public int height;
	private int gameDifficulty = 0;
	private int graphicsSetting;
	private static GameView gameView;
	private Vibrator vibrator;

	/**
	 * Creates the screen and retrieves the values passed from the previous screen.
	 */
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.gameplay);
		
		setScreenDimensions();
		
		gameDifficulty = getIntent().getIntExtra(DIFFICULTY, 1);
		graphicsSetting = getIntent().getIntExtra(GRAPHICS_SET, 0);
		
		initializeGame();
	}

	/**
	 * Sets the parameters for the game view and then initializes the game.
	 */
	private void initializeGame() {
		gameView = (GameView)findViewById(R.id.game_view);
		gameView.setFocusable(true);
		gameView.setFocusableInTouchMode(true);
		gameView.setDimensions(height, width);
		gameView.setTextView((TextView)findViewById(R.id.text));
		vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		gameView.setDifficulty(gameDifficulty);
		gameView.setGraphics(graphicsSetting);
		gameView.initializeBikes(vibrator);
	}

	/**
	 * Grabs screen dimensions and sets them to appropriate variables
	 */
	public void setScreenDimensions() {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		this.height = displayMetrics.heightPixels;
		this.width = displayMetrics.widthPixels;		
	}
}
