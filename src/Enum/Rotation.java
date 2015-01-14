package Enum;

public enum Rotation {
	UP(270),DOWN(90),RIGHT(0),LEFT(180);
	
	private int rotation;

	public int getRotation() {
		return rotation;
	}
	
	private Rotation (int rotation) {
		this.rotation = rotation;
	}
}
