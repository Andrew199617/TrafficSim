package edu.Cars;

import edu.cs150.TrafficWorld;

public abstract class WrapCar extends Car {
	


	protected void wrapAround(){
		if (image.equals(red) || image.equals(yellow)){
			if(this.getWorld() != null && this.getX() >= (TrafficWorld.worldWidth -1)){
				this.setLocation(2, this.getY());
			}
			else if (this.getWorld() != null && this.getX() < 1){
				this.setLocation(TrafficWorld.worldWidth -2, this.getY());
			}

			if(this.getWorld() != null && this.getY() >= (TrafficWorld.worldHeight - 1)){
				this.setLocation(this.getX(), 2);
			}
			else if (this.getWorld() != null && this.getY() < 1){
				this.setLocation(this.getX(),TrafficWorld.worldHeight - 2 );
			}
		}
	}
	
	
}
