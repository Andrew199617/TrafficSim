package edu.cs150;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class TrafficLights extends Actor {
	public static final GreenfootImage RED = new GreenfootImage("images/trafficLightRed.png");
	public static final GreenfootImage YELLOW = new GreenfootImage("images/trafficLightYellow.png");
	public static final GreenfootImage GREEN = new GreenfootImage("images/trafficLightGreen.png");
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
		
		if(Greenfoot.mouseClicked(getWorld())){
		if(this.getImage() == GREEN){
			setYellow();
		}
		else if(this.getImage() == YELLOW){
			setRed();
		}
		else if(this.getImage() == RED)
			setGreen();
		}
	}
}
