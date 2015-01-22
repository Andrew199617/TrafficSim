package edu.cs150;

import java.util.Random;

import Enum.Rotation;
import greenfoot.Actor;

public class Car extends Actor implements IListener {


	private boolean toTurn = false;
	private static final int ENDOFTURN = 42;
	private static final int N_TURNS = 6;



	private static final int DEGREEOFROTATION = 90;
	Random rand = new Random();
	int x;
	private int moveSpeed = 1;
	private int chance = 0;
	public int rotation = 0;
	private int timer;
	private boolean StopOrMove = false;
	private boolean test = false;


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

		removeCars();

		stopCar();
//		if(toTurn){this.turnRight();}
	}



	private void removeCars() {
		if(this.getWorld() != null && this.getX() >= (TrafficWorld.worldWidth -1)){
			this.getWorld().removeObject(this);
			if(TrafficWorld.carE2W.contains(this)){
				TrafficWorld.carE2W.remove(this);
			}
			if(TrafficWorld.carN2S.contains(this)){
				TrafficWorld.carN2S.remove(this);
			}
		}
		else if (this.getWorld() != null && this.getX() < 1){
			this.getWorld().removeObject(this);
			if(TrafficWorld.carE2W.contains(this)){
				TrafficWorld.carE2W.remove(this);
			}
			if(TrafficWorld.carN2S.contains(this)){
				TrafficWorld.carN2S.remove(this);
			}
		}

		if(this.getWorld() != null && this.getY() >= (TrafficWorld.worldHeight - 1)){
			this.getWorld().removeObject(this);
			if(TrafficWorld.carE2W.contains(this)){
				TrafficWorld.carE2W.remove(this);
			}
			if(TrafficWorld.carN2S.contains(this)){
				TrafficWorld.carN2S.remove(this);
			}
		}
		else if (this.getWorld() != null && this.getY() < 1){
			this.getWorld().removeObject(this);
			if(TrafficWorld.carE2W.contains(this)){
				TrafficWorld.carE2W.remove(this);
			}
			if(TrafficWorld.carN2S.contains(this)){
				TrafficWorld.carN2S.remove(this);
			}
		}
	}



	private void stopCar() {

		if(chance == State.APPROACHING.chance){StopOrMove = true;}

		if(chance == State.ENTERING.chance && StopOrMove){
			if(TrafficWorld.tLightsLeftRight.get(0).isRedLR()){
				if(this.rotation == Rotation.LEFT.getRotation() || this.rotation == Rotation.RIGHT.getRotation() ){
					this.setSpeed(0);
				}
			}
			else if(!TrafficWorld.tLightsLeftRight.get(0).isRedLR()){
				if(this.rotation == Rotation.LEFT.getRotation() || this.rotation == Rotation.RIGHT.getRotation() ){
					this.setSpeed(1);StopOrMove = false;
					//					int randnum = rand.nextInt(28);
					//					if(randnum == 0){toTurn = true;}
					toTurn = true;
				}
			}
			if(TrafficWorld.tLightsUpDown.get(0).isRedUD()){
				if(this.rotation == Rotation.UP.getRotation() || this.rotation == Rotation.DOWN.getRotation() ){
					this.setSpeed(0);
				}
			}
			else if(!TrafficWorld.tLightsUpDown.get(0).isRedUD()){
				if(this.rotation == Rotation.UP.getRotation() || this.rotation == Rotation.DOWN.getRotation() ){
					this.setSpeed(1);StopOrMove = false;
					//					int randnum = rand.nextInt(28);
					//					if(randnum == 0){toTurn = true;}
					toTurn = true;
				}
			}
		}


	}


	public void turnRight(){

		timer++;
		if (timer <= ENDOFTURN) {
			if (timer % (ENDOFTURN/N_TURNS) == 0) {
				this.turn(DEGREEOFROTATION/6);
				this.rotation -= DEGREEOFROTATION/6;
				if (this.rotation < 0) this.rotation += 360;
			}
		} else {
			toTurn = false;
			timer = 0;
		}

	}



	public void setSpeed(int i) {
		moveSpeed = i;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public int getChance() {
		return chance;
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



	@Override
	public void setTest(boolean test) {
		this.test = test;
		
	}
	
	@Override
	public boolean getTest(){
		return this.test;
	}

}
