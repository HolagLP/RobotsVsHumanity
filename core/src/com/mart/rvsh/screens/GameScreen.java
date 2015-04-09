package com.mart.rvsh.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mart.rvsh.Main;
import com.mart.rvsh.data.ComputerChips;
import com.mart.rvsh.data.Humanity;
import com.mart.rvsh.data.RobotStats;
import com.mart.rvsh.hud.onclick.ClickAmount;
import com.mart.rvsh.humanity.Detection;
import com.mart.rvsh.robots.AirBot;
import com.mart.rvsh.robots.Arachnotron;
import com.mart.rvsh.robots.Robot;
import com.mart.rvsh.robots.Scavenger;
import com.mart.rvsh.robots.StealthBot;
import com.mart.rvsh.world.KillButton;

public class GameScreen implements Screen{
	
	Main game;
	Stage stage;
	Skin skin;
	
	Humanity hum = new Humanity();
	ComputerChips cp = new ComputerChips();
	RobotStats rs = new RobotStats();
	
	//Robot Actors
	Robot robot;
	Scavenger scavenger;
	StealthBot stealthbot;
	AirBot airbot;
	Arachnotron arachnotron;
	
	//Misc Actors
	KillButton killbutton;
	Detection detection;
	
	long startTime = 0;
	long secondStartTime = 0;
	
	public final static Array<ClickAmount> clickAmounts = new Array<ClickAmount>();
	
	private String computerChips;
	private String CPS;
	
	public GameScreen(final Main game){
		this.game = game;
		robot = new Robot(game);
		scavenger = new Scavenger(game);
		stealthbot = new StealthBot(game);
		airbot = new AirBot(game);
		arachnotron = new Arachnotron(game);
		
		killbutton = new KillButton(game);
		detection = new Detection(game);
		
		startTime = TimeUtils.nanoTime();
		secondStartTime = TimeUtils.nanoTime();
		
		stage = new Stage(new ExtendViewport(1280, 704));
	    stage.addActor(robot);
	    stage.addActor(scavenger);
	    stage.addActor(stealthbot);
	    stage.addActor(airbot);
	    stage.addActor(arachnotron);
	    
	    stage.addActor(killbutton);
	    stage.addActor(detection);
	    
	    
	    Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        hum.increaseHumanity();
        
        if (TimeUtils.timeSinceNanos(startTime) > 100000000) { 
        	cp.finalComputerChips();
        	cp.randomChances();
        	hum.decreaseHumanity();
            cp.calculateCPS();
            rs.calculateRobotCPS();
        	startTime = TimeUtils.nanoTime();
        }
        
        if (TimeUtils.timeSinceNanos(secondStartTime) > 1000000000) { 
        	hum.setDetectedKills();
        	secondStartTime = TimeUtils.nanoTime();
        }
        
		stage.act();
		stage.draw();
		computerChips = "ComputerChips: " + ComputerChips.finalComputerChips;
		CPS = "CPS: " + ComputerChips.finalCPS;
        game.batch.begin();
        game.robotFontBig.draw(game.batch, "Humanity: " + Humanity.finalHumanity, 400, 700);
        game.robotFontMedium.draw(game.batch, computerChips, stage.getWidth()/2 - 
        		game.robotFontMedium.getBounds(computerChips).width/2, 668);
        game.robotFontSmall.draw(game.batch, CPS, stage.getWidth()/2 - 
        		game.robotFontSmall.getBounds(CPS).width/2, 640);
       
		for(ClickAmount click : clickAmounts){
			click.update(delta);
			click.render();
			if(click.timePassed >= 2){
				clickAmounts.removeValue(click, true);
			}
		}
		 game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		game.dispose();
		skin.dispose();
	}
	

}
