package edu.cs150;

import greenfoot.Actor;

public class Explosion extends Actor {

	private static final int ENDCHANGE = 60;
	private int timer = 0;
	private static final int CHANGE1 = ENDCHANGE/3;
	private static final int CHANGE2 = (ENDCHANGE/3)*2;
	private int W_Image = 0;
	public Explosion() {
		this.setImage("images/explosion1.png");
	}

	public void act (){
		if(timer <= ENDCHANGE){
			if(timer == CHANGE1 || timer == CHANGE2){
				if(W_Image == 0){
					W_Image++;
					setImage("images/explosion2.png");
				}
				else{
					W_Image = 0;
					setImage("images/explosion3.png");
				}
			}
			timer++;
		}
		else{
			this.getWorld().removeObject(this);
		}
		
	}
}
