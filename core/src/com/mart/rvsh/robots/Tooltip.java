package com.mart.rvsh.robots;

import com.badlogic.gdx.graphics.Color;
import com.mart.rvsh.Main;

public class Tooltip {
	Main game;
	private float x, y;
	String text;
	
	public Tooltip(float x, float y, String text, Main game){
		this.game = game;
		this.x = x;
		this.y = y;
		this.text = text;
	}

	public void render() {
		game.robotFontSmall.setColor(1,1,1,1f);
		game.robotFontSmall.draw(game.batch, text, x, y);
		game.robotFontSmall.setColor(Color.WHITE);
	}

}
