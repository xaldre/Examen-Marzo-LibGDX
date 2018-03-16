package com.libgdx.examen;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import actores.ActorManager;
import actores.Ball;
import actores.helpers.BallType;
import actores.helpers.IDList;
import utiles.MakingACage;
import utiles.Utiles;

public class MyGame {
	public static final int FactorZoomCamara = 3;
	SpriteBatch batch;
	World world;
	MakingACage cage;
	Stage stage;
	Box2DDebugRenderer debugRenderer;
	Matrix4 debugMatrix;
	OrthographicCamera camera;
	ActorManager actorManager;
	Viewport viewport;
	Choques choques;
	private boolean pause;

	public void create() {
		pause = false;
		batch = new SpriteBatch();
		world = new World(new Vector2(0, Utiles.GRAVITY), true);
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera(Gdx.graphics.getWidth() * Utiles.PIXELS_TO_METERS,
				Gdx.graphics.getHeight() * Utiles.PIXELS_TO_METERS);
		cage = new MakingACage(world, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Utiles.PIXELS_TO_METERS);
		cage.setID(IDList.MakingACage.toString());
		viewport = new ScreenViewport(camera);
		stage = new Stage(viewport, batch);
		stage = new Stage(viewport, batch);
		actorManager = new ActorManager(world);
		actorManager.createActors();
		actorManager.addActors(stage);
		choques = new Choques(actorManager);
		world.setContactListener(choques);
	}

	private void act() {
		if (!pause) {
			world.step(1f / 60f, 6, 2);
			stage.act();
		}
	}

	public void render() {
		this.act();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		debugMatrix = batch.getProjectionMatrix().cpy().scale(Utiles.PIXELS_TO_METERS, Utiles.PIXELS_TO_METERS, 0);

		// pantalla
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		debugRenderer.render(world, debugMatrix);
	}

	public void pause() {
		this.pause = true;
	}

	public void resume() {
		this.pause = false;
	}

	public void dispose() {
		batch.dispose();
		world.dispose();
	}

}
