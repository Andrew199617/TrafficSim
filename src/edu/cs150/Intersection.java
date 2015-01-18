package edu.cs150;

import java.awt.Color;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.List;

public class Intersection extends Actor {

	List<Car> actors;
	List<Car> actorsTwo;

	public Intersection (){

	}

	public void draw(int width, int height){
		GreenfootImage image = new GreenfootImage(width, height);
		image.setColor(Color.RED);
		image.fill();
		image.setTransparency(255);
		setImage(image);
	}

	public void act(){
		
		actors = this.getObjectsInRange(50, Car.class);
		actorsTwo = this.getObjectsInRange(52, Car.class);
		
		
		
		
		if(actors.isEmpty()){
			if(!actorsTwo.isEmpty()){
				System.out.println(actorsTwo.size());
				if(TrafficWorld.tLightsLeftRight.get(0).isRedLR()){
					for(int i1 = 0; i1 < actorsTwo.size();i1++){
						actorsTwo.get(i1).setSpeed(0);
					}
				}
				else if(!TrafficWorld.tLightsLeftRight.get(0).isRedLR()){
					for(int i1 = 0; i1 < actorsTwo.size();i1++){
						actorsTwo.get(i1).setSpeed(1);
					}
				}
			}
		}
	}
}




