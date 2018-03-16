package com.libgdx.examen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Arranque extends ApplicationAdapter {
	MyGame game;

	@Override
	public void create() {
		super.create();
		game = new MyGame();
		game.create();
	}

	@Override
	public void render() {
		game.render();
	}

	@Override
	public void dispose() {
		game.dispose();
	}

	@Override
	public void pause() {
		game.pause();
	}
	
	@Override
	public void resume() {
		game.resume();
	}
}
