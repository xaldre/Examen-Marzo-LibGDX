package actores;

import java.util.ArrayList;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import actores.helpers.BallType;
import actores.helpers.BodyFactory;

public class ActorManager {
	ArrayList<Ball> balls;
	BodyFactory bodyFactory;

	public ActorManager(World world) {
		super();
		this.bodyFactory = new BodyFactory(world);
		this.balls = new ArrayList<Ball>();
	}

	public void createActors() {
		Ball player = new ShepperdBall(bodyFactory);
		Ball lamb = new LambBall(bodyFactory, (ShepperdBall) player);
		balls.add(player);
		balls.add(new BouncingBall(bodyFactory, new Vector2(4f, 4f)));
		balls.add(new BouncingBall(bodyFactory, new Vector2(2f, 3f)));
		balls.add(lamb);
		balls.add(new WolfBall(bodyFactory, (LambBall) lamb));
		balls.add(new Bolon(bodyFactory));
		Gdx.input.setInputProcessor((InputProcessor) player);
	}

	public void addActors(Stage stage) {
		for (Ball ball : balls) {
			stage.addActor(ball);
		}
	}

	public Ball getActor(Body otherBody) {
		for (Ball ball : balls) {
			if (ball.body.equals(otherBody)) {
				return ball;
			}
		}
		return null;
	}

}
