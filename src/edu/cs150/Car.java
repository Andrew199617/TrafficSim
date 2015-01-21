package edu.cs150;

import java.util.Random;

import Enum.Rotation;
import greenfoot.Actor;

public class Car extends Actor implements IListener {
	Random rand = new Random();
	int x;
	private int moveSpeed = 1;
	private int chance = 0;
	private boolean stoped = false;
	public int rotation = 0;

	private enum State {
		APPROACHING(1),ENTERING(2),LEAVING(3),LEFT(4);

		private int chance = 1;

		private State(int chance){
			this.chance = chance;
		}


	}

	public Car () {
		x = rand.nextInt(4);
		if (x == 0){this.setImage("images/topCarBlue.png");}
		else if (x == 1){this.setImage("images/topCarPurple.png");}
		else if (x == 2){this.setImage("images/topCarRed.png");}
		else{this.setImage("images/topCarYellow.png");}
	}



	public void act (){
		move(moveSpeed);

		if(getX() >= (TrafficWorld.worldWidth -1)){
			int y = getY();
			setLocation(1,y );
		}
		else if (getX() < 1){
			int y = getY();
			setLocation(TrafficWorld.worldWidth -1,y );
		}

		if(getY() >= (TrafficWorld.worldHeight - 1)){
			int x= getX();
			setLocation(x,1 );
		}
		else if (getY() < 1){
			int x = getX();
			setLocation(x, TrafficWorld.worldHeight - 1 );
		}
		
		stopCar();
	}



	private void stopCar() {

		if(chance == State.APPROACHING.chance){

			if(TrafficWorld.tLightsLeftRight.get(0).isRedLR()){
				if(this.rotation == Rotation.LEFT.getRotation() || this.rotation == Rotation.RIGHT.getRotation() ){
					this.setSpeed(0);
				}
			}
			else if(!TrafficWorld.tLightsLeftRight.get(0).isRedLR()){
				if(this.rotation == Rotation.LEFT.getRotation() || this.rotation == Rotation.RIGHT.getRotation() ){
					this.setSpeed(1);
				}
			}
			if(TrafficWorld.tLightsUpDown.get(0).isRedUD()){
				if(this.rotation == Rotation.UP.getRotation() || this.rotation == Rotation.DOWN.getRotation() ){
					this.setSpeed(0);
				}
			}
			else if(!TrafficWorld.tLightsUpDown.get(0).isRedUD()){
				if(this.rotation == Rotation.UP.getRotation() || this.rotation == Rotation.DOWN.getRotation() ){
					this.setSpeed(1);
				}
			}

		}




	}






	public void setSpeed(int i) {
		moveSpeed = i;
	}




	public boolean isStoped() {
		return stoped;
	}

	public void setStoped(boolean stoped) {
		this.stoped = stoped;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}



	public int getChance() {
		return chance;
	}



	public void setChance(int chance) {
		this.chance = chance;
	}



	@Override
	public void approachingIntersection() {
		chance = State.APPROACHING.chance;

	}



	@Override
	public void enteringIntersection() {
		chance = State.ENTERING.chance;

	}



	@Override
	public void leavingIntersection() {
		chance = State.LEAVING.chance;

	}



	@Override
	public void goneIntersection() {
		chance = State.LEFT.chance;

	}

}
