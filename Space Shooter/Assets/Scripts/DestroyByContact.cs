using UnityEngine;
using System.Collections;

public class DestroyByContact : MonoBehaviour {

	public GameObject explosion;
	public GameObject playerExplosion;
	public int scoreValue;
	private GameController controller;

	void Start() {
		GameObject gameController = GameObject.FindWithTag("GameController");
		controller = gameController != null ? gameController.GetComponent<GameController>() : null;
		if (controller == null) Debug.Log("Cannot find GameController script");
	}

	public void OnTriggerEnter(Collider other) {
		if (other.tag == "Boundary") return;
		if (other.tag == "Player") {
			Instantiate(playerExplosion, other.transform.position, other.transform.rotation);
			controller.GameOver();
		}
		Instantiate(explosion, transform.position, transform.rotation);
		controller.AddScore(scoreValue);
		Destroy(other.gameObject);
		Destroy(gameObject);
	}
}
