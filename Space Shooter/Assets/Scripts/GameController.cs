using UnityEngine;
using System.Collections;

public class GameController : MonoBehaviour {

	public GameObject hazard;
	public Vector3 spawnValues;
	public int hazardCount;
	public float spawnWait;
	public float startWait;
	public float waveWait;

	public GUIText scoreText;
	public GUIText restartText;
	public GUIText gameOverText;

	private bool gameOver = false;
	private bool restart = false;
	private int score = 0;

	public void Start() {
		restartText.text = "";
		gameOverText.text = "";
		updateScore();
		StartCoroutine(spawnWaves());
	}

	public void Update() {
		if (restart && Input.GetKeyDown(KeyCode.R)) Application.LoadLevel(Application.loadedLevel);
	}

	public IEnumerator spawnWaves() {
		yield return new WaitForSeconds(startWait);
		//while (player.activeInHierarchy) {
		while (!gameOver) {
			for (int i = 0; i < hazardCount; i++) {
				Vector3 spawnPosition = new Vector3(Random.Range(-spawnValues.x, spawnValues.x), spawnValues.y, spawnValues.z); //random spawn location 
				Quaternion spawnRotation = Quaternion.identity; //asteroid rotation is handled in AsteroidRotator
				Instantiate(hazard, spawnPosition, spawnRotation);
				yield return new WaitForSeconds(spawnWait);
			}
			yield return new WaitForSeconds(waveWait);
		}
	}

	public void AddScore(int scoreValue) {
		score += scoreValue;
		updateScore();
	}

	public void updateScore() {
		scoreText.text = "Score: " + score;
	}

	public void GameOver() {
		gameOverText.text = "Game Over!";
		gameOver = true;
		restartText.text = "Press 'R' to restart";
		restart = true;
	}

}
