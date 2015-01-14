package Enum;

import edu.cs150.TrafficWorld;

public enum sideOfRoad {
	TOPORRIGHT((TrafficWorld.roadLength /4)*3),
	BOTORLEFT(TrafficWorld.roadLength /4);
	
	private int side;

	public int getSide() {
		return side;
	}

	private sideOfRoad (int side){
		this.side = side;
	}
	
}
