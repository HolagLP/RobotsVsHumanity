package com.mart.rvsh.robots;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mart.rvsh.Main;
import com.mart.rvsh.data.ComputerChips;
import com.mart.rvsh.data.RobotStats;
import com.mart.rvsh.screens.GameScreen;

public class Robot extends Actor{
	Main game;
	
	RobotStats rc = new RobotStats();
	
	private int x = 1050;
	private int y = 550;
	
	private String robotsS;
	
	Texture robot;
	TextureRegion region;
	
	String sk = System.getProperty("line.separator");
	
	
	public Robot(final Main game){
		region = new TextureRegion();
		this.game = game;
	    setBounds(1050, 530, 200, 20);
	    robot = new Texture(Gdx.files.internal("robots/Robot.png"));

	    addListener( new ClickListener() {              
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	        	if(ComputerChips.computerChips >= RobotStats.robotCost){
	        		ComputerChips.computerChips -= RobotStats.robotCost;
	        		RobotStats.robots++;
	        		rc.increaseRobotCost();
	        	}
	        };
	    });
	}

	@Override
    public void draw (Batch batch, float parentAlpha) {
		robotsS = "" + RobotStats.robots;
		game.batch.begin();
		game.robotFontMedium.draw(game.batch, "Robot", x, y);
		game.robotFontMedium.draw(game.batch, "X" + Gdx.input.getX(), 100, 100);
		game.robotFontMedium.draw(game.batch, "y" + Gdx.input.getY(), 200, 100);
		game.robotFontMedium.draw(game.batch, robotsS, x - game.robotFontMedium.getBounds(robotsS).width - 5, y);
		game.robotFontSmall.draw(game.batch, "" + RobotStats.finalRobotCost, x + game.robotFontMedium.getBounds(robotsS).width - 5, y-20);
		rc.calculateFinalCosts();
		
		int by = (int) game.robotFontMedium.getBounds("Robot\n").height;
		int bx = (int) game.robotFontMedium.getBounds("Robot\n").width;
		
		if(Gdx.input.getX() > x && Gdx.input.getX() < bx + x && 724 - Gdx.input.getY() > y  && 704 - Gdx.input.getY() < by + y){
			game.batch.draw(robot, 1007, y-25, 14, 31);
		}
		
		game.batch.end();
    }
}
