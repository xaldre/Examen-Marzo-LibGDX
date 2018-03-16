package actores;

import com.badlogic.gdx.math.Vector2;

import actores.helpers.BallType;
import actores.helpers.BodyFactory;
import actores.helpers.IDList;
import utiles.Utiles;

public class BouncingBall extends ComonBall {

	public BouncingBall(BodyFactory bodyFactory, Vector2 position) {
		super(bodyFactory, BallType.verde, position);
		this.body.applyForceToCenter(Utiles.pushRandom(0.5f, 0.5f), true);
	}

	@Override
	public boolean isReacting() {
		return true;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}

	@Override
	public void react(String elementId) {
		if ("ground".equals(elementId)) {
			Vector2 pushRandom = Utiles.pushRandom(0.1f, 0.2f);
			this.body.applyLinearImpulse(new Vector2(pushRandom.x, 0.08f), this.body.getLocalCenter(), true);
		}
	}

	@Override
	public void setID() {
		this.setID(IDList.BouncingBall.toString());
	}

	@Override
	protected void setUserData() {
		this.body.setUserData(this);
	}

}
