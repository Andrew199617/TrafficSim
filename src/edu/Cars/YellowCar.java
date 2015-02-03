package edu.Cars;

public class YellowCar extends WrapCar {

	public YellowCar() {
		image = yellow;
		setImage(image);
	}
	
	@Override
	protected void turnCar() {
		toTurnR = true;
	}

	public void act(){
		move(moveSpeed);
		crashing();
		stopCar();
		wrapAround();
		randomTurn(4);
		if(toTurnR){this.turnRight();}
	}
}
