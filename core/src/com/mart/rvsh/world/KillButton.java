package com.mart.rvsh.world;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mart.rvsh.Main;
import com.mart.rvsh.data.ComputerChips;
import com.mart.rvsh.data.Humanity;
import com.mart.rvsh.hud.onclick.ClickAmount;
import com.mart.rvsh.screens.GameScreen;

public class KillButton extends Actor{
	Main game;
	Texture texture;
	Sprite sprite;
	
	Humanity hum = new Humanity();
	ComputerChips cp = new ComputerChips();
	
	public KillButton(final Main game){
		this.game = game;
		texture = new Texture(Gdx.files.internal("buttons/Globe.png"));
		sprite = new Sprite(texture);
		sprite.setPosition(540, 252);
		sprite.setSize(200, 200);
		setBounds(sprite.getX(), sprite.getY(), 200, 200);
				
	    addListener( new ClickListener() {              
	        @Override
	        public void clicked(InputEvent event, float x, float y) {
	    		Random random = new Random();
	    		int someInt = (random.nextInt(3) - 1) * 5;
	        	GameScreen.clickAmounts.add(new ClickAmount(Gdx.input.getX() + someInt, 704 -Gdx.input.getY(), 1, game));
	        	hum.decreaseHumanityOnClick();
	        	cp.increaseComputerChipsOnClick();
	        };
	    });
	}
	
	@Override
    public void draw (Batch batch, float parentAlpha) {
		game.batch.begin();
		sprite.draw(game.batch);
		game.batch.end();
		setBounds(sprite.getX(), sprite.getY(), 200, 200);	
    }
}
