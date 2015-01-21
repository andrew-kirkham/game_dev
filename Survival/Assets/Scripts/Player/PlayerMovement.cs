using UnityEngine;

public class PlayerMovement : MonoBehaviour {

	public float speed = 6f;

	private Vector3 movement;
	private Animator anim;
	private Rigidbody playerRigidbody;
	private int floorMask;
	private float camRayLength = 100f;

	//awake is similar to start but gets called regardless
	public void Awake() {
		floorMask = LayerMask.GetMask("Floor");
		anim = GetComponent<Animator>();
		playerRigidbody = GetComponent<Rigidbody>();
	}

	//called every physics update instead of rendering
	public void FixedUpdate() {
		float horiz = Input.GetAxisRaw("Horizontal");
		float vert = Input.GetAxisRaw("Vertical");
		move(horiz, vert);
		turning();
		animating(horiz, vert);
	}

	private void animating(float horiz, float vert) {
		bool isWalking = horiz != 0f || vert != 0f;
		anim.SetBool("IsWalking", isWalking);
	}

	private void turning() {
		Ray camRay = Camera.main.ScreenPointToRay(Input.mousePosition);
		RaycastHit floorHit;
		if (Physics.Raycast(camRay, out floorHit, camRayLength, floorMask)) {
			Vector3 playerToMouse = floorHit.point - transform.position;
			playerToMouse.y = 0f;

			Quaternion newRotation = Quaternion.LookRotation(playerToMouse);
			playerRigidbody.MoveRotation(newRotation);
		}
	}

	private void move(float horiz, float vert) {
		movement.Set(horiz, 0f, vert);

		movement = movement.normalized * speed * Time.deltaTime;

		playerRigidbody.MovePosition(transform.position + movement);
	}
}
