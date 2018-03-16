package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import actores.helpers.BallType;
import actores.helpers.BodyFactory;
import actores.helpers.IDList;
import utiles.Utiles;

public class LambBall extends ComonBall {

	ShepperdBall pastor;
	boolean free;
	boolean scared;
	final float SCARE_MAX_DOWNTIME = 0.5f;
	float scareCurrentDowntime;
	float followRange = 0.5f;

	public LambBall(BodyFactory bodyFactory, ShepperdBall pastor) {
		super(bodyFactory, BallType.azul, new Vector2(520 / Utiles.PIXELS_TO_METERS, 380 / Utiles.PIXELS_TO_METERS));
		this.pastor = pastor;
		this.free = isNear();
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		if (!isScared()) {
			if (isNear()) {
				iFollow();
			} else {
				iRoam();
			}
		}
	}

	private boolean isScared() {
		scareCurrentDowntime += Gdx.graphics.getDeltaTime();
		if (scareCurrentDowntime > SCARE_MAX_DOWNTIME) {
			scareCurrentDowntime = 0;
			scared = false;
		}
		return scared;
	}

	private void iRoam() {
		this.body.setLinearVelocity(Utiles.pushRandom(10f, 10f));
	}

	private void iFollow() {
		this.body.setLinearVelocity(new Vector2(pastor.body.getLinearVelocity()));
	}

	private boolean isNear() {
		Vector2 pastorPosition = pastor.body.getPosition();
		Vector2 myPosition = this.body.getPosition();
		float xDistance, yDistance;
		xDistance = pastorPosition.x - myPosition.x;
		yDistance = pastorPosition.y - myPosition.y;
		xDistance = xDistance < 0 ? -xDistance : xDistance;
		yDistance = yDistance < 0 ? -yDistance : yDistance;
		if (xDistance < this.followRange && yDistance < this.followRange) {
			this.free = true;
		} else {
			this.free = false;
		}
		return free;
	}

	@Override
	public boolean isReacting() {
		return true;
	}

	@Override
	public void react(String elementId) {
		if (IDList.WolfBall.toString().equals(elementId)) {
			scare();
		}
		if (IDList.Bolon.toString().equals(elementId)) {
			System.out.println("LA OVEJA HA LLEGADO SANA Y SALVA AL BOLON!");
		}
	}

	private void scare() {
		this.scareCurrentDowntime = 0;
		this.scared = true;
		this.body.applyLinearImpulse(Utiles.pushRandom(0.2f, 0.2f), this.body.getLocalCenter(), true);
	}

	@Override
	public void setID() {
		this.setID(IDList.LambBall.toString());
	}

	@Override
	protected void setUserData() {
		this.body.setUserData(this);
	}

}
