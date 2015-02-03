package edu.Cars;

public class RedCar extends WrapCar {

	public RedCar() {
		image = red;
		setImage(image);
	}

	public void act() {
		move(moveSpeed);
		crashing();
		stopCar();
		wrapAround();
	}
	
	@Override
	protected void turnCar() {
	}
	
	
	
}
