package edu.cs150;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.Color;

public class Roads extends Actor {

	
	public Roads (){
		
	}

	public void draw(int width, int height){
		GreenfootImage image = new GreenfootImage(width, height);
		image.setColor(Color.GRAY);
		image.fill();
		setImage(image);
	}
}
