package Enum;

import edu.cs150.TrafficWorld;

public enum sideOfRoad {
	TOPORRIGHT((TrafficWorld.roadLength /5)*4 ),
	BOTORLEFT(TrafficWorld.roadLength /5);
	
	private int side;

	public int getSide() {
		return side;
	}

	private sideOfRoad (int side){
		this.side = side;
	}
	
}
