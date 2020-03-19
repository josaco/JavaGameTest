package graphics;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage player;

	// effects

	public static BufferedImage speed;

	public static void init()

	{
		player = Loader.ImageLoader("/ships/Player.png");

		speed = Loader.ImageLoader("/effects/fire08.png");
	}

}
