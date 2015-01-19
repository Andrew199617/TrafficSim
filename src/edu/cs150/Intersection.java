package edu.cs150;

import java.awt.Color;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.List;

import Enum.Rotation;

public class Intersection extends Actor implements IListener {

	List<Car> actors;
	List<Car> actorsTwo;
	List<Car> actorsThree;

	private enum State {
		APPROACHING(true),ENTERING(true),LEAVING(false),LEFT(false);

		public boolean chance;

		private State(boolean chance){
			this.chance = chance;
		}


	}


	public Intersection (){

	}

	public void draw(int width, int height){
		GreenfootImage image = new GreenfootImage(width, height);
		image.setColor(Color.RED);
		image.fill();
		image.setTransparency(0);
		setImage(image);
	}

	public void act(){

		actors = this.getObjectsInRange(50, Car.class);
		actorsTwo = this.getObjectsInRange(52, Car.class);
		actorsThree = this.getObjectsInRange(60, Car.class);

		approachingIntersection();
		enteringIntersection();
		leavingIntersection();
		goneIntersection();

		if(actors.isEmpty()){
			if(!actorsTwo.isEmpty()){
				stopCar();
			}
		}
	}


	private void stopCar() {
		for(int i1 = 0; i1 < actorsTwo.size();i1++){
			if(actorsThree.get(i1).isChance()){
				if(TrafficWorld.tLightsLeftRight.get(0).isRedLR()){
					if(actorsTwo.get(i1).rotation == Rotation.LEFT.getRotation() || actorsTwo.get(i1).rotation == Rotation.RIGHT.getRotation() ){
						actorsTwo.get(i1).setSpeed(0);
					}
				}
				else if(!TrafficWorld.tLightsLeftRight.get(0).isRedLR()){
					if(actorsTwo.get(i1).rotation == Rotation.LEFT.getRotation() || actorsTwo.get(i1).rotation == Rotation.RIGHT.getRotation() ){
						actorsTwo.get(i1).setSpeed(1);
					}
				}
				if(TrafficWorld.tLightsUpDown.get(0).isRedUD()){
					if(actorsTwo.get(i1).rotation == Rotation.UP.getRotation() || actorsTwo.get(i1).rotation == Rotation.DOWN.getRotation() ){
						actorsTwo.get(i1).setSpeed(0);
					}
				}
				else if(!TrafficWorld.tLightsUpDown.get(0).isRedUD()){
					if(actorsTwo.get(i1).rotation == Rotation.UP.getRotation() || actorsTwo.get(i1).rotation == Rotation.DOWN.getRotation() ){
						actorsTwo.get(i1).setSpeed(1);
					}
				}
			}
		}
	}

	public void approachingIntersection() {

		for(int i1 = 0; i1 < actorsThree.size();i1++){
			if(actorsTwo.isEmpty()){
				if(!actorsThree.isEmpty()){
					actorsThree.get(i1).setChance(State.APPROACHING.chance);
				}
			}

		}

	}

	@Override
	public void enteringIntersection() {
		for(int i1 = 0; i1 < actorsTwo.size();i1++){
			if(actorsTwo.get(i1).getMoveSpeed() == 0){
				if(actors.isEmpty()){
					if(actorsThree.get(i1).isChance()){
						actorsThree.get(i1).setChance(State.ENTERING.chance);
					}
				}
			}

		}

	}

	@Override
	public void leavingIntersection() {
		for(int i1 = 0; i1 < actorsTwo.size();i1++){
			if(actorsTwo.get(i1).getMoveSpeed() == 1){
				if(!actors.isEmpty()){
					if(actorsThree.get(i1).isChance()){
						actorsThree.get(i1).setChance(State.LEAVING.chance);
					}
				}
			}

		}

	}

	@Override
	public void goneIntersection() {
		for(int i1 = 0; i1 < actorsTwo.size();i1++){
			if(!actorsThree.get(i1).isChance()){
				if(!actorsThree.isEmpty()){
					if(actorsTwo.isEmpty()){
						if(actors.isEmpty()){
							actorsThree.get(i1).setChance(State.LEFT.chance);

						}
					}
				}
			}
		}

	}

}





