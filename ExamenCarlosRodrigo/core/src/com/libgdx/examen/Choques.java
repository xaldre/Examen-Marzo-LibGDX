package com.libgdx.examen;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import actores.ActorManager;
import actores.Ball;
import interfaces.Elemento;
import utiles.ContactAdapter;

public class Choques extends ContactAdapter {

	ActorManager actorManager;

	public Choques(ActorManager actorManager) {
		super();
		this.actorManager = actorManager;
	}

	@Override
	public void beginContact(Contact contact) {
		Object fixtureUserDataA = contact.getFixtureA().getUserData();
		Object fixtureUserDataB = contact.getFixtureB().getUserData();
		Elemento a = (Elemento) contact.getFixtureA().getBody().getUserData();
		Elemento b = (Elemento) contact.getFixtureB().getBody().getUserData();
		if (fixtureUserDataA != null) {
			if (((Ball) b).isReacting()) {
				((Ball) b).react(fixtureUserDataA.toString());
			}
		}
		if (fixtureUserDataB != null) {
			if (((Ball) a).isReacting()) {
				((Ball) a).react(fixtureUserDataB.toString());
			}
		}
		if (a.isReacting()) {
			((Ball) a).colisiona(b);
		}
		if (b.isReacting()) {
			((Ball) b).colisiona(a);
		}

	}
}
