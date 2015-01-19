package edu.cs150;

import java.util.Random;

import greenfoot.Actor;

public class Car extends Actor  {
	Random rand = new Random();
	int x;
	private int moveSpeed = 1;
	private boolean chance = true;
	private boolean stoped = false;
	public int rotation = 0;
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

	}

	public void setSpeed(int i) {
		moveSpeed = i;
	}

	
	public boolean isChance() {
		return chance;
	}

	public void setChance(boolean chance) {
		this.chance = chance;
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
	
}
