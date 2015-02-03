package edu.Cars;

public class PurpleCar extends RemovedCar {

	public PurpleCar() {
		image = purple;
		setImage(image);
	}
	
	@Override
	protected void turnCar() {
		toTurnL = true;
		findLocation = true;
	}
	
	public void act() {
		move(moveSpeed);
		randomTurn(4);
		crashing();
		stopCar();
		removeCars();
		if(this.getWorld() != null && toTurnL){this.leftTurnPrep();}
		if(realTurnL){this.turnLeft();}
	}

}
