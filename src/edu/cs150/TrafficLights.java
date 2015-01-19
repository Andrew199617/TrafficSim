package edu.cs150;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class TrafficLights extends Actor {
	public static final GreenfootImage RED = new GreenfootImage("images/trafficLightRed.png");
	public static final GreenfootImage YELLOW = new GreenfootImage("images/trafficLightYellow.png");
	public static final GreenfootImage GREEN = new GreenfootImage("images/trafficLightGreen.png");
	private static final int TIMEBESWITCH = 50000;
	private static int timer = TIMEBESWITCH;
	private static boolean isRedUD = false;
	private static boolean isRedLR = true;

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
		else if(timer > 0){
			changeToYellow();
			timer--;
		}
		else if(timer == 0){
			y2RandR2G();
			timer = TIMEBESWITCH; 
		}

	}

	private void y2RandR2G() {
		for(int i = 0; i < TrafficWorld.tLightsUpDown.size();i++){
			if(TrafficWorld.tLightsUpDown.get(i).getImage() == YELLOW){
				TrafficWorld.tLightsUpDown.get(i).setImage(RED);
				setRedUD(true);
			}
			else if(TrafficWorld.tLightsUpDown.get(i).getImage() == RED){
				TrafficWorld.tLightsUpDown.get(i).setImage(GREEN);
				setRedUD(false);
			}
		}
		for(int i = 0; i < TrafficWorld.tLightsLeftRight.size();i++){
			if(TrafficWorld.tLightsLeftRight.get(i).getImage() == YELLOW){
				TrafficWorld.tLightsLeftRight.get(i).setImage(RED);
				setRedLR(true);
			}
			else if(TrafficWorld.tLightsLeftRight.get(i).getImage() == RED){
				TrafficWorld.tLightsLeftRight.get(i).setImage(GREEN);
				setRedLR(false);
			}
		}
	}

	private void changeToYellow() {
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

	public static boolean isRedLR() {
		return isRedLR;
	}

	public static void setRedLR(boolean isRedLR) {
		TrafficLights.isRedLR = isRedLR;
	}

	public static boolean isRedUD() {
		return isRedUD;
	}

	public static void setRedUD(boolean isRedUD) {
		TrafficLights.isRedUD = isRedUD;
	}
}
