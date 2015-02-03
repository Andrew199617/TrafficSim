package edu.Cars;

public class BlueCar extends RemovedCar {


	private boolean blueTurned = true;
	
	public BlueCar() {
		image = blue;
		setImage(image);
	}
	
	@Override
	protected void turnCar() {
		if(blueTurned){
			toTurnL = true;
			findLocation = true;
			blueTurned = false;
			turnOrNah = false;
			toTurnR = false;
		}
		else{
			toTurnR = true;	
			blueTurned = true;
			turnOrNah = false;
			toTurnL = false;
		}
	}
	
	public void act(){
		randomTurn(1);
		move(moveSpeed);
		if(toTurnR){this.turnRight();}
		if(this.getWorld() != null && toTurnL){this.leftTurnPrep();}
		if(realTurnL){this.turnLeft();}
		stopCar();
		crashing();
		removeCars();
		
	}

}
