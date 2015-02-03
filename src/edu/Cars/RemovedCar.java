package edu.Cars;

import edu.cs150.TrafficWorld;

public abstract class RemovedCar extends Car {



	protected void removeCars() {
		if(this.getWorld() != null && this.getX() >= (TrafficWorld.worldWidth -1)){
			this.getWorld().removeObject(this);
			if(TrafficWorld.carE2W.contains(this)){
				TrafficWorld.carE2W.remove(this);
			}
			if(TrafficWorld.carN2S.contains(this)){
				TrafficWorld.carN2S.remove(this);
			}
		}
		else if (this.getWorld() != null && this.getX() < 1){
			this.getWorld().removeObject(this);
			if(TrafficWorld.carE2W.contains(this)){
				TrafficWorld.carE2W.remove(this);
			}
			if(TrafficWorld.carN2S.contains(this)){
				TrafficWorld.carN2S.remove(this);
			}
		}

		if(this.getWorld() != null && this.getY() >= (TrafficWorld.worldHeight - 1)){
			this.getWorld().removeObject(this);
			if(TrafficWorld.carE2W.contains(this)){
				TrafficWorld.carE2W.remove(this);
			}
			if(TrafficWorld.carN2S.contains(this)){
				TrafficWorld.carN2S.remove(this);
			}
		}
		else if (this.getWorld() != null && this.getY() < 1){
			this.getWorld().removeObject(this);
			if(TrafficWorld.carE2W.contains(this)){
				TrafficWorld.carE2W.remove(this);
			}
			if(TrafficWorld.carN2S.contains(this)){
				TrafficWorld.carN2S.remove(this);
			}
		}

	}

}
