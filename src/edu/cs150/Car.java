package edu.cs150;

import java.util.Random;

import greenfoot.Actor;

public class Car extends Actor implements IListener {
	Random rand = new Random();
	int x;
	private int moveSpeed = 1;
	public Car () {
		x = rand.nextInt(4);
		if (x == 0){this.setImage("images/topCarBlue.png");}
		else if (x == 1){this.setImage("images/topCarPurple.png");}
		else if (x == 2){this.setImage("images/topCarRed.png");}
		else{this.setImage("images/topCarYellow.png");}
	}
	
	private enum State {
		INSIDE,NEAR,FAR
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
		
	}
	
	public void setSpeed(int i) {
		moveSpeed = i;
	}

	@Override
	public void approachingIntersection() {
		
		
	}

	@Override
	public void enteringIntersection() {
		
	}

	@Override
	public void leavingIntersection() {
		
	}

	@Override
	public void goneIntersection() {
		
	}

}
