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
	private boolean hasTurnedRed = false;

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

	
	private void turnRed() {
		for(int i = 0; i < TrafficWorld.tLightsUpDown.size();i++){
			if(TrafficWorld.tLightsUpDown.get(i).getImage() == YELLOW){
				setRedUD(true);
				TrafficWorld.tLightsUpDown.get(i).hasTurnedRed = true;
				TrafficWorld.tLightsUpDown.get(i).setImage(RED);
			}
		}
		for(int i = 0; i < TrafficWorld.tLightsLeftRight.size();i++){
			if(TrafficWorld.tLightsLeftRight.get(i).getImage() == YELLOW){
				setRedLR(true);
				TrafficWorld.tLightsLeftRight.get(i).hasTurnedRed = true;
				TrafficWorld.tLightsLeftRight.get(i).setImage(RED);
			}
		}
	}

	
	
	private void turnGreen() {
		for(int i = 0; i < TrafficWorld.tLightsUpDown.size();i++){
			if(!TrafficWorld.tLightsUpDown.get(i).hasTurnedRed){
				if(TrafficWorld.tLightsUpDown.get(i).getImage() == RED){
					setRedUD(false);
					TrafficWorld.tLightsUpDown.get(i).setImage(GREEN);
				}
			}
		}

		for(int i = 0; i < TrafficWorld.tLightsLeftRight.size();i++){
			if(!TrafficWorld.tLightsLeftRight.get(i).hasTurnedRed){
				if(TrafficWorld.tLightsLeftRight.get(i).getImage() == RED){
					setRedLR(false);
					TrafficWorld.tLightsLeftRight.get(i).setImage(GREEN);
				}
			}
		}
		for(int i = 0; i < TrafficWorld.tLightsUpDown.size();i++){
			TrafficWorld.tLightsUpDown.get(i).hasTurnedRed = false;
		}
		for(int i = 0; i < TrafficWorld.tLightsLeftRight.size();i++){
			TrafficWorld.tLightsLeftRight.get(i).hasTurnedRed = false;
		}
	}

	
	
	private void turnYellow() {
		for(int i = 0; i < TrafficWorld.tLightsUpDown.size();i++){
			if(TrafficWorld.tLightsUpDown.get(i).getImage() == GREEN){
				TrafficWorld.tLightsUpDown.get(i).setImage(YELLOW);

			}
		}
		for(int i = 0; i < TrafficWorld.tLightsLeftRight.size();i++){
			if(TrafficWorld.tLightsLeftRight.get(i).getImage() == GREEN){
				TrafficWorld.tLightsLeftRight.get(i).setImage(YELLOW);

			}
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
