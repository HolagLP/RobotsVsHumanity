package com.mart.rvsh.hud.onclick;


import com.badlogic.gdx.graphics.Color;
import com.mart.rvsh.Main;

public class ClickAmount {
	
	private Main game;
	private final int amount;
	private float x, y;
	public float timePassed;
	private float timepassed = 1.0f;
	
	public ClickAmount(float x2, float y2, int amount, Main game) {
		this.game = game;
		this.x = x2;
		this.y = y2;
		this.amount = amount;
	}
	 
	public void update(float delta) {
	        timePassed += delta;
	        timepassed -= delta / 2.1;
	}

	public void render() {
		 game.RobotMediumFont.setColor(1,1,1,timepassed);
	     game.RobotMediumFont.draw(game.batch, "+" + amount, x , y + (int) (timePassed * 50));
	     game.RobotMediumFont.setColor(Color.WHITE);
	      
	}
}
