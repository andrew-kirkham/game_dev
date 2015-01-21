using UnityEngine;
using System.Collections;

public class CameraFollow : MonoBehaviour {

	public Transform target;
	public float smoothing = 5f;

	private Vector3 offset;

	public void Start() {
		offset = transform.position - target.position;
	}

	public void FixedUpdate() {
		Vector3 targetCameraPosition = target.position + offset;
		transform.position = Vector3.Lerp(transform.position, targetCameraPosition, smoothing * Time.deltaTime);
	}
}
	