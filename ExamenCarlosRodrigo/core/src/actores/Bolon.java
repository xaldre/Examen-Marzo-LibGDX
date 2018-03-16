package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import actores.helpers.BallType;
import actores.helpers.BodyFactory;
import actores.helpers.IDList;
import utiles.Utiles;

public class Bolon extends Ball {

	static final float INITIAL_OFFSET = ((BallType.bolon.getSize() + 3) / 2);
	static final float PERFECT_OFFSET = (BallType.bolon.getSize() / 2);
	private Vector2 movement = new Vector2(1, 0);

	public Bolon(BodyFactory bodyFactory) {
		super(bodyFactory, BallType.bolon, BodyType.KinematicBody,
				new Vector2((0 + INITIAL_OFFSET) / Utiles.PIXELS_TO_METERS,
						(Gdx.graphics.getHeight() - INITIAL_OFFSET) / Utiles.PIXELS_TO_METERS));
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		checkDirection();
		move();
	}

	private void checkDirection() {
		if ((this.body.getPosition().x >= (Gdx.graphics.getWidth() - PERFECT_OFFSET) / Utiles.PIXELS_TO_METERS)
				|| (this.body.getPosition().x <= (0 + PERFECT_OFFSET) / Utiles.PIXELS_TO_METERS)) {
			this.movement.x = -this.movement.x;
		}
	}

	private void move() {
		this.body.setLinearVelocity(movement);
	}

	@Override
	public boolean isReacting() {
		return false;
	}

	@Override
	public void react(String elementId) {
		// NO REACTION
	}

	@Override
	protected void defineSprite() {
		this.sprite = new Sprite(new Texture(Gdx.files.internal("bolabase.png")));
		sprite.setSize(type.getSize(), type.getSize());
		sprite.setOrigin(0, 0);
	}

	@Override
	public void setID() {
		this.setID(IDList.Bolon.toString());
	}

	@Override
	protected void setUserData() {
		this.body.setUserData(this);
	}

}
