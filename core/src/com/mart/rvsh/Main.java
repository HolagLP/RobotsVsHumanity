package com.mart.rvsh;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.mart.rvsh.screens.GameScreen;

public class Main extends Game {
	
    public SpriteBatch batch;
    public BitmapFont robotFontBig;
    public BitmapFont robotFontMedium;
    public BitmapFont robotFontSmall;
    
    public BitmapFont RobotBigFont;
    public BitmapFont RobotMediumFont;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/robotaur.ttf"));
        FreeTypeFontParameter parameter1 = new FreeTypeFontParameter();
        FreeTypeFontParameter parameter2 = new FreeTypeFontParameter();
        FreeTypeFontParameter parameter3 = new FreeTypeFontParameter();
        parameter1.size = 30;
        parameter2.size = 20;
        parameter3.size = 15;
        robotFontBig = generator.generateFont(parameter1); 
        robotFontBig.setColor(Color.WHITE);
        robotFontMedium = generator.generateFont(parameter2); 
        robotFontMedium.setColor(Color.WHITE);
        robotFontSmall = generator.generateFont(parameter3); 
        robotFontSmall.setColor(Color.WHITE);
        generator.dispose(); 
        
        
        RobotMediumFont = new BitmapFont(Gdx.files.internal("fonts/RBMediumFont.fnt"), Gdx.files.internal("fonts/RBMediumFont.png"), false);
        RobotMediumFont.setScale(1, 1);
        this.setScreen(new GameScreen(this));
        

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	@Override
	public void dispose(){
        batch.dispose();
        robotFontBig.dispose();
        robotFontMedium.dispose();
        robotFontSmall.dispose();
	}
	
}
