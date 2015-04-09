package com.mart.rvsh.robots;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mart.rvsh.Main;
import com.mart.rvsh.data.ComputerChips;
import com.mart.rvsh.data.RobotStats;

public class AirBot extends Actor{
	Main game;
	
	TextureRegion region;
	RobotStats rc = new RobotStats();
	
	private int x = 1050;
	private int y = 450;
	
	private String airBots;
	
	
	public AirBot(Main game){
		region = new TextureRegion();
		this.game = game;
	    setBounds(1050, 430, 200, 20);

	    addListener( new ClickListener() {              
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	        	if(ComputerChips.computerChips >= RobotStats.airbotCost){
	        		ComputerChips.computerChips -= RobotStats.airbotCost;
	        		RobotStats.airbots++;
	        		rc.increaseRobotCost();
	        	}
	        };
	    });
	}

	@Override
    public void draw (Batch batch, float parentAlpha) {
		airBots = "" + RobotStats.airbots;
		game.batch.begin();
		game.robotFontMedium.draw(game.batch, "AirBot", x, y);
		game.robotFontMedium.draw(game.batch, airBots, x - game.robotFontMedium.getBounds(airBots).width - 5, y);
		game.robotFontSmall.draw(game.batch, "" + RobotStats.finalAirBotCost, x + game.robotFontMedium.getBounds(airBots).width - 5, y-20);
		rc.calculateFinalCosts();
		game.batch.end();

    }
}
