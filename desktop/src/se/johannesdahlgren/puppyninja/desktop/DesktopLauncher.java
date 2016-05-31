package se.johannesdahlgren.puppyninja.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import se.johannesdahlgren.puppyninja.PuppyNinja;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = PuppyNinja.TITLE;
		config.width = 640;
		config.height = 480;
		new LwjglApplication(new PuppyNinja(), config);
	}
}
