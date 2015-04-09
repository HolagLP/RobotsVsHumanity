package com.mart.rvsh.robots;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mart.rvsh.Main;
import com.mart.rvsh.data.ComputerChips;
import com.mart.rvsh.data.RobotStats;

public class Arachnotron extends Actor{
	Main game;
	
	TextureRegion region;
	RobotStats rc = new RobotStats();
	
	private int x = 1050;
	private int y = 400;
	
	private String Arachnotrons;
	
	
	public Arachnotron(Main game){
		region = new TextureRegion();
		this.game = game;
	    setBounds(1050, 380, 200, 20);

	    addListener( new ClickListener() {              
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	        	if(ComputerChips.computerChips >= RobotStats.arachnotronCost){
	        		ComputerChips.computerChips -= RobotStats.arachnotronCost;
	        		RobotStats.arachnotrons++;
	        		rc.increaseRobotCost();
	        	}
	        };
	    });
	}

	@Override
    public void draw (Batch batch, float parentAlpha) {
		Arachnotrons = "" + RobotStats.arachnotrons;
		game.batch.begin();
		game.robotFontMedium.draw(game.batch, "Arachnotron", x, y);
		game.robotFontMedium.draw(game.batch, Arachnotrons, x - game.robotFontMedium.getBounds(Arachnotrons).width - 5, y);
		game.robotFontSmall.draw(game.batch, "" + RobotStats.finalArachnotronCost, x + game.robotFontMedium.getBounds(Arachnotrons).width - 5, y-20);
		rc.calculateFinalCosts();
		game.batch.end();

    }
}
