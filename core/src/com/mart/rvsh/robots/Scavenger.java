package com.mart.rvsh.robots;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mart.rvsh.Main;
import com.mart.rvsh.data.ComputerChips;
import com.mart.rvsh.data.RobotStats;

public class Scavenger extends Actor{
	
	Main game;
	
	TextureRegion region;
	RobotStats rc = new RobotStats();
	
	private int x = 1050;
	private int y = 600;
	
	private String scavengers;
	
	public Scavenger(Main game){
		region = new TextureRegion();
		this.game = game;
	    setBounds(1050, 580, 200, 20);

	    addListener( new ClickListener() {              
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	        	if(ComputerChips.computerChips >= RobotStats.scavengerCost){
	        		ComputerChips.computerChips -= RobotStats.scavengerCost;
	        		RobotStats.scavengers++;
	        		rc.increaseRobotCost();
	        	}
	        };
	    });
	}

	@Override
    public void draw (Batch batch, float parentAlpha) {
		scavengers = "" + RobotStats.scavengers;
		game.batch.begin();
		game.robotFontMedium.draw(game.batch, "Scavenger", x, y);
		game.robotFontMedium.draw(game.batch, "X" + Gdx.input.getX(), 100, 100);
		game.robotFontMedium.draw(game.batch, "y" + Gdx.input.getY(), 200, 100);
		game.robotFontMedium.draw(game.batch, scavengers, x - game.robotFontMedium.getBounds(scavengers).width - 5, y);
		game.robotFontSmall.draw(game.batch, "" + RobotStats.finalScavengerCost, x + game.robotFontMedium.getBounds(scavengers).width - 5, y-20);
		rc.calculateFinalCosts();
		game.batch.end();

    }
}
