package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import actores.helpers.BallType;
import actores.helpers.BodyFactory;
import actores.helpers.IDList;
import utiles.Utiles;

public class WolfBall extends ComonBall {

	LambBall lamb;

	public WolfBall(BodyFactory bodyFactory, LambBall lamb) {
		super(bodyFactory, BallType.roja, new Vector2((Gdx.graphics.getWidth() / 2) / Utiles.PIXELS_TO_METERS,
				(Gdx.graphics.getHeight() / 2) / Utiles.PIXELS_TO_METERS));
		this.lamb = lamb;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		followPrey();
	}

	private void followPrey() {
		Vector2 myPosition = this.body.getPosition();
		Vector2 lambPosition = lamb.body.getPosition();
		this.body.setLinearVelocity(
				Utiles.calculateTrigonmetricDirection(myPosition.x, myPosition.y, lambPosition.x, lambPosition.y));
	}

	@Override
	public boolean isReacting() {
		return false;
	}

	@Override
	protected void setUserData() {
		this.body.setUserData(this);
	}

	@Override
	public void react(String elementId) {
		// No React
	}

	@Override
	public void setID() {
		this.setID(IDList.WolfBall.toString());
	}

}
