package edu.cs150;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import Enum.Rotation;
import Enum.sideOfRoad;
import greenfoot.World;

public class TrafficWorld extends World {

	public ArrayList<Car> cars = new ArrayList<Car>();
	Random rand = new Random();
	private static final int RoadsN2S = 7;
	private static final int RoadsE2W = 5;
	private static final int carsN2S = (RoadsN2S * 2);
	private static final int carsE2W = (RoadsE2W * 2);
	public static final int worldWidth = 1000;
	public static final int worldHeight = 750;
	public static final int roadLength = 50;
	public static final int grassTopLength = ((worldWidth - (roadLength * RoadsN2S))/(RoadsN2S - 1));
	public static final int grassSideLength = ((worldHeight - (roadLength * RoadsE2W))/(RoadsE2W - 1));
	
	public TrafficWorld () {
		super(worldWidth,worldHeight,1);
		this.getBackground().setColor(Color.GREEN);
		this.getBackground().fill();

		
		
		
		
		int y = sideOfRoad.TOPORRIGHT.getSide();
		int x = sideOfRoad.BOTORLEFT.getSide();
		for(int i = 0; i < carsE2W; i++){
			Car car = new Car();
			if (i >= (carsE2W / 2)){
				car.setRotation(Rotation.LEFT.getRotation());
			}
			x = (rand.nextInt(worldWidth - 2) + 1);
			cars.add(car);
			this.addObject(car, x, y);
			y += (roadLength + grassSideLength);
			if(y > (worldHeight - 1)){
				y = sideOfRoad.BOTORLEFT.getSide();
			}
			
		}
		
		x = (roadLength /4);
		for(int i = 0; i < carsN2S; i++){
			Car car = new Car();
			if (i >= (carsN2S / 2)){
				car.setRotation(Rotation.UP.getRotation());
			}
			else{car.setRotation(Rotation.DOWN.getRotation());}
			y = (rand.nextInt(worldHeight - 2) + 1);
			cars.add(car);
			this.addObject(car, x, y);
			x += (roadLength + grassTopLength);
			if(x > (worldWidth - 1)){
				x = sideOfRoad.TOPORRIGHT.getSide();
			}
			
			
		}
	}

	public void draw(){

		for (int x = 0; x < TrafficWorld.worldHeight; x += (TrafficWorld.roadLength + TrafficWorld.grassSideLength)){
			Roads rs = new Roads();
			this.addObject(rs, 0, 0);
		}
		
		for (int x = 0; x < TrafficWorld.worldWidth; x += (TrafficWorld.roadLength + TrafficWorld.grassTopLength)){
			Roads rs = new Roads();
			this.addObject(rs, 0, 0);
		}
		
	}
	
}
