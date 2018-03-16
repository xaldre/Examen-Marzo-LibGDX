package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import actores.helpers.BallType;
import actores.helpers.BodyFactory;

public abstract class ComonBall extends Ball {

	public ComonBall(BodyFactory bodyFactory, BallType type, Vector2 position) {
		super(bodyFactory, type, BodyType.DynamicBody, position);
	}

	@Override
	protected void defineSprite() {
		textureMapa = new TextureAtlas(Gdx.files.internal("bola.atlas"));
		sprite = new Sprite(new TextureRegion(textureMapa.findRegion(type.getColor())));
		sprite.setSize(type.getSize(), type.getSize());
		sprite.setOrigin(0, 0);
	}

}
