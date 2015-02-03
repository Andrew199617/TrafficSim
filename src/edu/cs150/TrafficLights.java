package edu.cs150;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class TrafficLights extends Actor {
	public static final GreenfootImage RED = new GreenfootImage("images/trafficLightRed.png");
	public static final GreenfootImage YELLOW = new GreenfootImage("images/trafficLightYellow.png");
	public static final GreenfootImage GREEN = new GreenfootImage("images/trafficLightGreen.png");
	private static final int TIMEBESWITCH = 75000;
	private static int timer = TIMEBESWITCH;
	private static boolean isRedUD = false;
	private static boolean isRedLR = true;
	private static boolean hasTurnedRedLR = false;
	private static boolean hasTurnedRedUD = true;

	public TrafficLights(){

	}

	public void setRed(){
		this.setImage(RED);
	}

	public void setYellow(){
		this.setImage(YELLOW);
	}

	public void setGreen(){
		this.setImage(GREEN);
	}

	public void act (){

		if(timer >TIMEBESWITCH/10){
			setTheHasTurnedReds();
			timer--;
		}
		else if(timer > TIMEBESWITCH/13){
			turnYellow();
			timer--;
		}
		else if(timer > 0){
			turnRed();
			timer--;
		}
		else if(timer == 0){
			turnGreen();
			timer = TIMEBESWITCH; 
		}

	}

	private void setTheHasTurnedReds() {
		if(TrafficWorld.tLightsLeftRight.get(0).getImage() == RED){
			hasTurnedRedLR = false;
		}
		else if(TrafficWorld.tLightsUpDown.get(0).getImage() == RED){
			hasTurnedRedUD = false;
		}
	}


	private void turnRed() {
		if(TrafficWorld.tLightsUpDown.get(0).getImage() == YELLOW){
			setRedUD(true);
			hasTurnedRedUD = true;
			for(int i = 0; i < TrafficWorld.tLightsUpDown.size();i++)
				TrafficWorld.tLightsUpDown.get(i).setImage(RED);
		}

		if(TrafficWorld.tLightsLeftRight.get(0).getImage() == YELLOW){
			setRedLR(true);
			hasTurnedRedLR = true;
			for(int i = 0; i < TrafficWorld.tLightsLeftRight.size();i++)
				TrafficWorld.tLightsLeftRight.get(i).setImage(RED);
		}

	}



	private void turnGreen() {
		if(!hasTurnedRedUD){
			if(TrafficWorld.tLightsUpDown.get(0).getImage() == RED){
				setRedUD(false);
				hasTurnedRedUD = false;
				for(int i = 0; i < TrafficWorld.tLightsUpDown.size();i++)
					TrafficWorld.tLightsUpDown.get(i).setImage(GREEN);
			}
		}
		if(!hasTurnedRedLR){
			if(TrafficWorld.tLightsLeftRight.get(0).getImage() == RED){
				setRedLR(false);
				hasTurnedRedLR = false;
				for(int i = 0; i < TrafficWorld.tLightsLeftRight.size();i++)
					TrafficWorld.tLightsLeftRight.get(i).setImage(GREEN);
			}
		}

	}



	private void turnYellow() {
		if(TrafficWorld.tLightsUpDown.get(0).getImage() == GREEN){
			for(int i = 0; i < TrafficWorld.tLightsUpDown.size();i++)
				TrafficWorld.tLightsUpDown.get(i).setImage(YELLOW);
		}

		if(TrafficWorld.tLightsLeftRight.get(0).getImage() == GREEN){
			for(int i = 0; i < TrafficWorld.tLightsLeftRight.size();i++)
				TrafficWorld.tLightsLeftRight.get(i).setImage(YELLOW);
		}

	}



	public boolean isRedLR() {
		return isRedLR;
	}

	public static void setRedLR(boolean isRedLR) {
		TrafficLights.isRedLR = isRedLR;
	}

	public boolean isRedUD() {
		return isRedUD;
	}

	public static void setRedUD(boolean isRedUD) {
		TrafficLights.isRedUD = isRedUD;
	}
}
