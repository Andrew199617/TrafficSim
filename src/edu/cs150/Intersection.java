package edu.cs150;

import java.awt.Color;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.ArrayList;
import java.util.List;


public class Intersection extends Actor {

	List<IListener> actors = new ArrayList<IListener>();
	List<IListener> actorsTwo= new ArrayList<IListener>();

	int delay = 50;

	public Intersection (){

	}

	public void draw(int width, int height){
		GreenfootImage image = new GreenfootImage(width, height);
		image.setTransparency(0);
		setImage(image);
	}

	public void act(){

		@SuppressWarnings("unchecked")
		List<IListener> inRange = this.getObjectsInRange(TrafficWorld.roadLength, IListener.class);
		@SuppressWarnings("unchecked")
		List<IListener> inRange2 = this.getObjectsInRange(TrafficWorld.roadLength + 5, IListener.class);


		approachingIntersection(inRange2);
		enteringIntersection(inRange);
		leavingIntersection(inRange);
		goneIntersection(inRange2);
		actorsTwo = inRange2;
		actors = inRange;
	}

	public void approachingIntersection(List<IListener> inRange) {
		for(IListener c: inRange){
			if(!actorsTwo.contains(c)){
				c.approachingIntersection();
			}
		}
	}


	public void enteringIntersection(List<IListener> inRange) {
		for(IListener c: inRange){
			if(!actors.contains(c)){
				c.enteringIntersection();		
			}
		}
	}


	public void leavingIntersection(List<IListener> inRange) {
		for(IListener c: actors){
			if(!inRange.contains(c)){
				c.leavingIntersection();
			}
		}
	}


	public void goneIntersection(List<IListener> inRange) {
		for(IListener c: actorsTwo){
			if(!inRange.contains(c)){
				c.goneIntersection();
			}
		}
	}

}





