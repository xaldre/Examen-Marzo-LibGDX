package utiles;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import interfaces.Elemento;

public class MakingACage implements Elemento {

	private Body ground, ceiling, leftWall, rightWall;
	private String id;

	public MakingACage(World world, float inferiorMargin, float Width, float Height, float scale) {

		Width /= scale;
		Height /= scale;

		// body definition
		BodyDef bodyDef2 = new BodyDef();
		bodyDef2.type = BodyDef.BodyType.StaticBody;
		bodyDef2.position.set(0, inferiorMargin);

		// the shape
		EdgeShape edgeShape = new EdgeShape();

		// defining fixture
		FixtureDef fixtureDef2 = new FixtureDef();

		// By each element
		// ground
		edgeShape.set(0, 0, Width, 0);
		fixtureDef2.shape = edgeShape;
		ground = world.createBody(bodyDef2);
		ground.createFixture(fixtureDef2).setUserData("ground");
		ground.setUserData(this);
		edgeShape.set(0, Height, Width, Height);
		fixtureDef2.shape = edgeShape;
		ceiling = world.createBody(bodyDef2);
		ceiling.createFixture(fixtureDef2).setUserData("ceiling");
		ceiling.setUserData(this);
		edgeShape.set(0, 0, 0, Height);
		fixtureDef2.shape = edgeShape;
		leftWall = world.createBody(bodyDef2);
		leftWall.createFixture(fixtureDef2).setUserData("leftWall");
		leftWall.setUserData(this);
		edgeShape.set(Width, 0, Width, Height);
		fixtureDef2.shape = edgeShape;
		rightWall = world.createBody(bodyDef2);
		rightWall.createFixture(fixtureDef2).setUserData("rightWall");
		rightWall.setUserData(this);
		edgeShape.dispose();
	}

	public void destroi() {
		World world = ground.getWorld();
		world.destroyBody(ground);
		world.destroyBody(ceiling);
		world.destroyBody(leftWall);
		world.destroyBody(rightWall);
	}

	@Override
	public boolean isReacting() {
		return false;
	}

	@Override
	public String getID() {
		return this.id;
	}

	@Override
	public void setID(String id) {
		this.id = id;
	}

	// @Override
	// public void aceptar(Colisionador colisionador) {
	// // TODO Auto-generated method stub
	//
	// }

}
