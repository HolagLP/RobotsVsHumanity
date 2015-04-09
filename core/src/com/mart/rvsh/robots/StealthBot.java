package com.mart.rvsh.robots;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mart.rvsh.Main;
import com.mart.rvsh.data.ComputerChips;
import com.mart.rvsh.data.RobotStats;

public class StealthBot extends Actor{
	Main game;
	
	TextureRegion region;
	RobotStats rc = new RobotStats();
	
	private int x = 1050;
	private int y = 500;
	
	private String stealthbots;
	
	
	public StealthBot(Main game){
		region = new TextureRegion();
		this.game = game;
	    setBounds(1050, 480, 200, 20);

	    addListener( new ClickListener() {              
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	        	if(ComputerChips.computerChips >= RobotStats.stealthbotCost){
	        		ComputerChips.computerChips -= RobotStats.stealthbotCost;
	        		RobotStats.stealthbots++;
	        		rc.increaseRobotCost();
	        	}
	        };
	    });
	}

	@Override
    public void draw (Batch batch, float parentAlpha) {
		stealthbots = "" + RobotStats.stealthbots;
		game.batch.begin();
		game.robotFontMedium.draw(game.batch, "StealthBot", x, y);
		game.robotFontMedium.draw(game.batch, stealthbots, x - game.robotFontMedium.getBounds(stealthbots).width - 5, y);
		game.robotFontSmall.draw(game.batch, "" + RobotStats.finalStealthBotCost, x + game.robotFontMedium.getBounds(stealthbots).width - 5, y-20);
		rc.calculateFinalCosts();
		game.batch.end();

    }
}
