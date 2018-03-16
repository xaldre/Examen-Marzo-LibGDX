package actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.scenes.scene2d.Actor;

import actores.helpers.BallType;
import actores.helpers.BodyFactory;
import interfaces.Colisonable;
import interfaces.Elemento;
import utiles.Utiles;

public abstract class Ball extends Actor implements Elemento, Colisonable, Cloneable {
	Sprite sprite;
	TextureAtlas textureMapa;
	Body body;
	String id;
	BallType type;

	public Ball(BodyFactory bodyFactory, BallType type, BodyType bodyType, Vector2 position) {
		this.type = type;
		defineSprite();
		body = bodyFactory.createBody(sprite, bodyType, position);
		CircleShape shape = new CircleShape();
		shape.setRadius(sprite.getWidth() / 2 / Utiles.PIXELS_TO_METERS);
		body.createFixture(defineFixtureDef(shape));
		shape.dispose();
		setID();
		this.setUserData();
	}

	protected abstract void setUserData();

	protected FixtureDef defineFixtureDef(Shape shape) {
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 0.1f;
		return fixtureDef;
	}

	protected abstract void defineSprite();

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		sprite.draw(batch);
	}

	public void dispose() {
		sprite.getTexture().dispose();
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		sprite.setPosition(body.getPosition().x * Utiles.PIXELS_TO_METERS - sprite.getWidth() / 2,
				body.getPosition().y * Utiles.PIXELS_TO_METERS - sprite.getHeight() / 2);
	}

	public abstract void react(String elementId);

	@Override
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * Call setID(String id) with specific class ID
	 */
	public abstract void setID();

	@Override
	public String getID() {
		return this.id;
	}

	@Override
	public void colisiona(Elemento obj) {
		if (this.isReacting()) {
			this.react(obj.getID());
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
