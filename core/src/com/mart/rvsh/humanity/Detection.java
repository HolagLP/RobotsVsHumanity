package com.mart.rvsh.humanity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mart.rvsh.Main;
import com.mart.rvsh.data.Humanity;

public class Detection extends Actor{
	Main game;
	
	 String detectionLevel;
	
	 int detectionNumber;
	
	public Detection(Main game){
		this.game = game;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		setDetection();
		detectionLevel = "Detection: " + detectionNumber + "%";
		game.batch.begin();
		game.robotFontBig.draw(game.batch, detectionLevel, 620-game.robotFontMedium.getBounds(detectionLevel).width/2 , 120);
		game.batch.end();
	}
	
	public void setDetection(){
		detectionNumber =(int) Math.floor(Humanity.detectedKills/1000);
	}
}
