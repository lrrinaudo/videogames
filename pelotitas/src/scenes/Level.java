package scenes;

import java.util.ArrayList;
import java.util.Collection;

import com.uqbar.vainilla.GameScene;
import components.Pelotita;

public class Level extends GameScene {

	private Collection<Pelotita> pelotitas = new ArrayList<Pelotita>();

	public Collection<Pelotita> getBolitas() {
		return this.pelotitas;
	}

	public void addPelotita(Pelotita b) {
		this.pelotitas.add(b);
		this.addComponent(b);
	}
}
