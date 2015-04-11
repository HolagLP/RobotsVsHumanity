package com.mart.rvsh.robots;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mart.rvsh.Main;
import com.mart.rvsh.data.ComputerChips;
import com.mart.rvsh.data.RobotStats;

public class UnderTaker extends Actor{
	Main game;
	
	TextureRegion region;
	RobotStats rc = new RobotStats();
	
	private int x = 1050;
	private int y = 350;
	
	private String Undertakers;
	
	
	public UnderTaker(Main game){
		region = new TextureRegion();
		this.game = game;
	    setBounds(1050, 330, 200, 20);

	    addListener( new ClickListener() {              
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	        	if(ComputerChips.computerChips >= RobotStats.undertakerCost){
	        		ComputerChips.computerChips -= RobotStats.undertakerCost;
	        		RobotStats.undertakers++;
	        		rc.increaseRobotCost();
	        	}
	        };
	    });
	}

	@Override
    public void draw (Batch batch, float parentAlpha) {
		Undertakers = "" + RobotStats.undertakers;
		game.batch.begin();
		game.robotFontMedium.draw(game.batch, "UnderTaker", x, y);
		game.robotFontMedium.draw(game.batch, Undertakers, x - game.robotFontMedium.getBounds(Undertakers).width - 5, y);
		game.robotFontSmall.draw(game.batch, "" + RobotStats.finalUnderTakerCost, x + game.robotFontMedium.getBounds(Undertakers).width - 5, y-20);
		rc.calculateFinalCosts();
		game.batch.end();

    }
}
