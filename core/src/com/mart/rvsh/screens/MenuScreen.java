package com.mart.rvsh.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mart.rvsh.Main;

public class MenuScreen implements Screen{
	
	Main game;
	Stage stage;
	Skin skin;
	
	final TextButton playButton;
	final TextButton exitButton;
	final TextButton optionsButton;
	
	public MenuScreen(final Main game){
		this.game = game;
	    stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		skin = new Skin();
		skin.add("white", new Texture(Gdx.files.internal("buttons/play.png")));
		skin.add("exit", new Texture(Gdx.files.internal("buttons/exit.png")));
		skin.add("options", new Texture(Gdx.files.internal("buttons/options.png")));
		
		BitmapFont bfont=new BitmapFont();
		bfont.scale(1);
		skin.add("default",bfont);
		
		TextButtonStyle playButtonStyle = new TextButtonStyle();
		playButtonStyle.up = skin.newDrawable("white", Color.LIGHT_GRAY);
		playButtonStyle.down = skin.newDrawable("white", Color.LIGHT_GRAY);
		playButtonStyle.over = skin.newDrawable("white", Color.DARK_GRAY);
		playButtonStyle.font = skin.getFont("default");
		
		TextButtonStyle exitButtonStyle = new TextButtonStyle();
		exitButtonStyle.up = skin.newDrawable("exit", Color.LIGHT_GRAY);
		exitButtonStyle.down = skin.newDrawable("exit", Color.LIGHT_GRAY);
		exitButtonStyle.over = skin.newDrawable("exit", Color.DARK_GRAY);
		exitButtonStyle.font = skin.getFont("default");
		
		TextButtonStyle optionsButtonStyle = new TextButtonStyle();
		optionsButtonStyle.up = skin.newDrawable("options", Color.LIGHT_GRAY);
		optionsButtonStyle.down = skin.newDrawable("options", Color.LIGHT_GRAY);
		optionsButtonStyle.over = skin.newDrawable("options", Color.DARK_GRAY);
		optionsButtonStyle.font = skin.getFont("default");
 
		skin.add("default", playButtonStyle);
		skin.add("exit", exitButtonStyle);
		skin.add("options", optionsButtonStyle);

		
		playButton=new TextButton("",playButtonStyle);
		exitButton = new TextButton("", exitButtonStyle);
		optionsButton = new TextButton("", optionsButtonStyle);
		playButton.setPosition(stage.getWidth()/2 - 72, stage.getHeight()/2 + 100);
		exitButton.setPosition(stage.getWidth()/2 - 72, stage.getHeight()/2- 100);
		optionsButton.setPosition(stage.getWidth()/2 - 72, stage.getHeight()/2);
		playButton.setWidth(144);
		playButton.setHeight(70);
		exitButton.setWidth(144);
		exitButton.setHeight(70);
		optionsButton.setWidth(144);
		optionsButton.setHeight(70);
		stage.addActor(playButton);
		stage.addActor(exitButton);
		stage.addActor(optionsButton);
	

	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
		stage.act();
		stage.draw();

        game.batch.begin();
        game.batch.end();
        
		playButton.addListener( new ClickListener() {              
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		    	game.setScreen(new GameScreen(game));
		    };
		});
		
		exitButton.addListener( new ClickListener() {              
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		    };
		});
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
		game.batch.dispose();
		stage.dispose();
		skin.dispose();
	}

}
