package actores.helpers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

import utiles.Utiles;

public class BodyFactory {

	World world;

	public BodyFactory(World world) {
		super();
		this.world = world;
	}

	public Body createBody(Sprite sprite, BodyType type, Vector2 position) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = type;
		bodyDef.position.set(position.x, position.y);
		return world.createBody(bodyDef);
	}

}
