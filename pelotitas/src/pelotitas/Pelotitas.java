package pelotitas;

import java.awt.Color;
import java.awt.Dimension;

import scenes.Level;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import components.Pelotita;

public class Pelotitas extends Game {

	// ****************************************************************
	// ** STATICS
	// ****************************************************************

	public static void main(String[] args) throws Exception {
		new DesktopGameLauncher(new Pelotitas()).launch();
	}

	@Override
	protected void initializeResources() {
	}

	@Override
	protected void setUpScenes() {
		Level scene = new Level();

		for(int i = 0; i < 3; i++) {
			scene.addPelotita(new Pelotita(Color.RED, Color.BLUE));
		}
		scene.addPelotita(new Pelotita(Color.BLACK, Color.YELLOW));

		this.setCurrentScene(scene);
	}

	@Override
	public Dimension getDisplaySize() {
		return new Dimension(500, 500);
	}

	@Override
	public String getTitle() {
		return "Pelotitas";
	}
}
