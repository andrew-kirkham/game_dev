using UnityEngine;
using System.Collections;

public class KillBox : MonoBehaviour {
	public void OnTriggerExit(Collider other) {
		Destroy(other.gameObject);
	}
}
