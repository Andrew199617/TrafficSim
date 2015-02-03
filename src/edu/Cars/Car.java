package edu.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.cs150.Explosion;
import edu.cs150.IListener;
import edu.cs150.TrafficWorld;
import Enum.Rotation;
import greenfoot.Actor;

public abstract class Car extends Actor implements IListener {


	protected boolean toTurnR = false;
	protected boolean toTurnL = false;
	protected boolean realTurnL = false;
	protected static final int ENDOFTURN = 36;
	protected static final int N_TURNS = 6;

	protected List<Car> actors = new ArrayList<Car>();

	protected static final int DEGREEOFROTATION = 90;
	protected Random rand = new Random();
	protected int moveSpeed = 1;
	protected int chance = 0;
	public int rotation = 0;
	protected int timer;
	protected boolean StopOrMove = false;
	protected boolean crashed = false;

	protected int xExplosion = 0;
	protected int yExplosion = 0;
	protected boolean turnOrNah = false;
	protected boolean findLocation = true;

	protected String image = "";
	protected String blue = "images/topCarBlue.png";
	protected String purple = "images/topCarPurple.png";
	protected String red = "images/topCarRed.png";
	protected String yellow = "images/topCarYellow.png";
	protected int x1;
	protected int y1;

	private enum State {
		APPROACHING(1),ENTERING(2),LEAVING(3),LEFT(4);

		private int chance = 1;

		private State(int chance){
			this.chance = chance;
		}


	}



	protected void crashing() {
		try {
			crashed();
		} catch (Exception e) {
			this.xExplosion = this.getX();
			this.yExplosion = this.getY();
			Explosion ex = new Explosion();
			ex.setRotation(this.rotation);
			this.getWorld().addObject(ex, xExplosion, yExplosion);
			if(TrafficWorld.carE2W.contains(this)){
				TrafficWorld.carE2W.remove(this);
			}
			else if(TrafficWorld.carN2S.contains(this)){
				TrafficWorld.carN2S.remove(this);
			}
			this.getWorld().removeObject(this);
			System.out.println(e.getMessage());
		}
	}



	protected void stopCar() {

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
				}
			}
		}


	}

	public void randomTurn(int b){

		if(chance == State.APPROACHING.chance){turnOrNah  = true;}

		if(chance == State.ENTERING.chance && turnOrNah){
			if(!TrafficWorld.tLightsUpDown.get(0).isRedUD() ){
				if(this.rotation == Rotation.UP.getRotation() || this.rotation == Rotation.DOWN.getRotation()){
					int randnum = rand.nextInt(b);
					if(randnum == 0){
						turnCar();
					}
					else{
						turnOrNah = false;
					}

				}
			}
			if(!TrafficWorld.tLightsLeftRight.get(0).isRedLR() ){
				if(this.rotation == Rotation.RIGHT.getRotation() || this.rotation == Rotation.LEFT.getRotation()){
					int randnum = rand.nextInt(b);
					if(randnum == 0){
						turnCar();
					}
					else{
						turnOrNah = false;
					}

				}
			}
		}
	}


	protected abstract void turnCar(); 


	public void turnRight(){
		toTurnL = false;
		realTurnL = false;
		timer++;
		if (timer <= ENDOFTURN) {
			if (timer % (ENDOFTURN/N_TURNS) == 0) {
				this.turn(DEGREEOFROTATION/6);
				this.rotation += DEGREEOFROTATION/6;
				if (this.rotation >= 360) this.rotation -= 360;
			}
		} else {
			toTurnR = false;
			timer = 0;
		}

	}

	public void turnLeft(){
		toTurnR = false;
		timer++;
		if (timer <= ENDOFTURN) {
			if (timer % (ENDOFTURN/N_TURNS) == 0) {
				this.turn(-DEGREEOFROTATION/6);
				this.rotation -= DEGREEOFROTATION/6;
				if (this.rotation < 0 ) this.rotation += 360;
			}
		} else {
			realTurnL = false;
			timer = 0;
		}
	}
	
	
	public void leftTurnPrep(){
		if(findLocation){
			x1 = this.getX();
			y1 = this.getY();
			findLocation = false;
		}
		int x2 = this.getX();
		int y2 = this.getY();
		if(this.rotation == Rotation.RIGHT.getRotation() ){
			if(x1 + (TrafficWorld.roadLength/4*3) == x2 ){
				realTurnL = true;
				toTurnL = false;
			}
		}
		else if(this.rotation == Rotation.UP.getRotation()){
			if(y1 - (TrafficWorld.roadLength/4*3) == y2){
				realTurnL = true;
				toTurnL = false;
			}
		}
		else if(this.rotation == Rotation.DOWN.getRotation()){
			if(y1 + (TrafficWorld.roadLength/4*3) == y2){
				realTurnL = true;
				toTurnL = false;
			}
		}
		else if(this.rotation == Rotation.LEFT.getRotation()){
			if(x1 - (TrafficWorld.roadLength/4*3) == x2){
				realTurnL = true;
				toTurnL = false;
			}
		}
	}


	

	public void crashed() throws Exception{
		@SuppressWarnings("unchecked")
		List<Car> check = this.getIntersectingObjects(Car.class);

		for(Car c: check){
			if(!actors.contains(c)){
				c.crashed = true;
			}
		}
		if(this.crashed == true){
			throw new Exception("Car Crashed");
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


}
