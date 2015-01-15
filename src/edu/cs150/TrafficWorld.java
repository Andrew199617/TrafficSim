package edu.cs150;

import greenfoot.World;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import Enum.Rotation;
import Enum.sideOfRoad;

public class TrafficWorld extends World {

	public ArrayList<Car> cars = new ArrayList<Car>();
	public ArrayList<TrafficLights> tLightsUpDown = new ArrayList<TrafficLights>();
	public ArrayList<TrafficLights> tLightsLeftRight = new ArrayList<TrafficLights>();
	Random rand = new Random();
	//	private static final int LIGHTWIDTH = 15;
	private static final int LIGHTLENGTH = 35;
	private static final int RoadsN2S = 7;
	private static final int RoadsE2W = 5;
	private static final int carsN2S = (RoadsN2S * 2);
	private static final int carsE2W = (RoadsE2W * 2);
	public static final int worldWidth = 1000;
	public static final int worldHeight = 750;
	public static final int roadLength = 75;
	public static final int grassTopLength = ((worldWidth - (roadLength * RoadsN2S))/(RoadsN2S - 1));
	public static final int grassSideLength = ((worldHeight - (roadLength * RoadsE2W))/(RoadsE2W - 1));

	public TrafficWorld () {
		super(worldWidth,worldHeight,1);
		this.getBackground().setColor(Color.GREEN);
		this.getBackground().fill();

		makeRoads();
		makeTrafficLightsUD();
		makeTrafficLightsLR();
		makeCars();

	}

	private void makeCars() {
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

	public void makeRoads(){

		for (int x = 0; x < TrafficWorld.worldHeight; x += (TrafficWorld.roadLength + TrafficWorld.grassSideLength)){
			Roads rs = new Roads();
			this.addObject(rs, worldWidth / 2, x + (roadLength/2));
			rs.draw(worldWidth,roadLength);
		}

		for (int x = 0; x < TrafficWorld.worldWidth; x += (TrafficWorld.roadLength + TrafficWorld.grassTopLength)){
			Roads rs = new Roads();
			this.addObject(rs, x + (roadLength/2), worldHeight /2);
			rs.draw(roadLength,worldHeight);
		}


	}	

	public void makeTrafficLightsUD(){

		for(int x = (roadLength/2); x < worldWidth; x+= roadLength + grassTopLength){
			for(int y = ((LIGHTLENGTH / 2) + roadLength); y < worldHeight;y += roadLength + grassSideLength ){
				TrafficLights trafficLights = new TrafficLights();
				trafficLights.setRotation(Rotation.DOWN.getRotation());
				trafficLights.setGreen();
				this.addObject(trafficLights, x, y);
				tLightsUpDown.add(trafficLights);
			}
			for(int y = ((roadLength + grassSideLength)-(LIGHTLENGTH / 2)); y < worldHeight;y += roadLength + grassSideLength ){
				TrafficLights trafficLights = new TrafficLights();
				trafficLights.setRotation(Rotation.UP.getRotation());
				trafficLights.setGreen();
				this.addObject(trafficLights, x, y);
				tLightsUpDown.add(trafficLights);
			}
		}

	}

	public void makeTrafficLightsLR(){
		for(int y = (roadLength/2); y < worldHeight;y += roadLength + grassSideLength ){
			for(int x = ((LIGHTLENGTH/2)+roadLength); x < worldWidth; x+= roadLength + grassTopLength){
				TrafficLights trafficLights = new TrafficLights();
				//trafficLights.setRotation(Rotation.RIGHT.getRotation());
				trafficLights.setRed();
				this.addObject(trafficLights, x, y);
				tLightsLeftRight.add(trafficLights);
			}
			for(int x = ((roadLength + grassTopLength)-(LIGHTLENGTH/2)); x < worldWidth; x+= roadLength + grassTopLength){
				TrafficLights trafficLights = new TrafficLights();
				trafficLights.setRotation(Rotation.LEFT.getRotation());
				trafficLights.setRed();
				this.addObject(trafficLights, x, y);
				tLightsLeftRight.add(trafficLights);
			}
		}


	}

}
