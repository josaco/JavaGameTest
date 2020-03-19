package gameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import game.Ventana;
import graphics.Assets;
import input.KeyBoard;
import math.Vector2D;

public class Player extends MovingObject {

	private Vector2D heading;
	private Vector2D acceleration;
	private final double ACC = 0.2;
	private final double DELTAANGLE = 0.1;

	public Player(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture) {
		super(position, velocity, maxVel, texture);
		heading = new Vector2D(0, 1);
		acceleration = new Vector2D();
	}

	@Override
	public void update() {
		if (KeyBoard.RIGHT) {
			angle += DELTAANGLE;
		}

		if (KeyBoard.LEFT) {
			angle -= DELTAANGLE;
		}

		if (KeyBoard.UP) {
			acceleration = heading.scale(ACC);
		} else {
			if (velocity.getMagnitude() != 0)
				acceleration = velocity.scale(-1).normalize().scale(ACC / 2);
		}

		velocity = velocity.add(acceleration);

		velocity = velocity.limit(maxVel);

		heading = heading.setDirection(angle - Math.PI / 2);

		position = position.add(velocity);

		if (position.getX() > Ventana.WIDTH)
			position.setX(0);
		if (position.getY() > Ventana.HEIGHT)
			position.setY(0);

		if (position.getX() < 0)
			position.setX(Ventana.WIDTH);
		if (position.getY() < 0)
			position.setY(Ventana.HEIGHT);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		at = AffineTransform.getTranslateInstance(position.getX(), position.getY());

		at.rotate(angle, width / 2, height / 2);

		g2d.drawImage(Assets.player, at, null);
	}

}
