using UnityEngine;
using System.Collections;

public class AsteroidRotator : MonoBehaviour {

	public float tumble;

	public void Start() {
		//randomly rotate the asteroid
		rigidbody.angularVelocity = Random.insideUnitSphere * tumble;
	}
}
