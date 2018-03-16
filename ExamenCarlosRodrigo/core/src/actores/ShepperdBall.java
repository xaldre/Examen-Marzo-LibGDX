package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import actores.helpers.BallType;
import actores.helpers.BodyFactory;
import actores.helpers.IDList;
import utiles.Utiles;

public class ShepperdBall extends ComonBall implements InputProcessor {
	boolean w, a, s, d;
	float velocity = 1.5f;

	public ShepperdBall(BodyFactory bodyFactory) {
		super(bodyFactory, BallType.naranja, new Vector2(0.1f, 0.1f));
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		move();
	}

	private void move() {
		if (w)
			body.setLinearVelocity(new Vector2(body.getLinearVelocity().x, velocity));
		if (a)
			if (!w)
				body.setLinearVelocity(new Vector2(-velocity, 0));
			else
				body.setLinearVelocity(new Vector2(-velocity, body.getLinearVelocity().y));
		if (d)
			if (!w)
				body.setLinearVelocity(new Vector2(velocity, 0));
			else
				body.setLinearVelocity(new Vector2(velocity, body.getLinearVelocity().y));
		if (s)
			body.setLinearVelocity(new Vector2(body.getLinearVelocity().x, -2.5f));
	}

	@Override
	public boolean isReacting() {
		return false;
	}

	@Override
	public void react(String elementId) {
		// No react
	}

	@Override
	public void setID() {
		this.setID(IDList.ShepperdBall.toString());
	}

	@Override
	protected void setUserData() {
		this.body.setUserData(this);
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.W || w) {
			w = true;
		}
		if (keycode == Input.Keys.A || a) {
			a = true;
		}
		if (keycode == Input.Keys.S || s) {
			s = true;
		}
		if (keycode == Input.Keys.D || d) {
			d = true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Input.Keys.W) {
			w = false;
		}
		if (keycode == Input.Keys.A) {
			a = false;
		}
		if (keycode == Input.Keys.S) {
			s = false;
		}
		if (keycode == Input.Keys.D) {
			d = false;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
