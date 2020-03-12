package gameObjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import input.KeyBoard;
import math.Vector2D;

public class Player extends GameObject {

	public Player(Vector2D position, BufferedImage texture) {
		super(position, texture);

	}

	@Override
	public void update() {
		if (KeyBoard.RIGHT) {
			position.setX(position.getX() + 5);
		}
		if (KeyBoard.LEFT) {
			position.setX(position.getX() - 5);
		}
		if (KeyBoard.UP) {
			position.setY(position.getY() - 5);
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(texture, (int) position.getX(), (int) position.getY(), null);

	}

}
