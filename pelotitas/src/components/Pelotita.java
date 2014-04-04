package components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import scenes.Level;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;
import com.uqbar.vainilla.colissions.CollisionDetector;

public class Pelotita extends GameComponent<Level> {

	private int radius = 15;
	private double speed = 120;
	private double i, j;
	private Color changedColor;
	private int tamanio;

	public Pelotita(Color baseColor, Color changedColor) {
		this.setAppearance(new Circle(baseColor, 2 * this.radius));
		this.tamanio = this.radius * 2;
		this.changedColor = changedColor;
	}

	@Override
	public void onSceneActivated() {
		Random random = new Random();

		this.setX(random.nextDouble() * this.getGame().getDisplayWidth());
		this.setY(random.nextDouble() * this.getGame().getDisplayHeight());
		
		// Para que la pelotita nunca arranque fuera del area de pelotitas:
		
		if(this.getX() - this.tamanio >= 0){
			this.setX(this.getX() - this.tamanio);
		}
		
		if(this.getY() - this.tamanio >= 0){
			this.setY(this.getY() - this.tamanio);
		}		
		
		//////////////////////////////////////////////////////////////////
		
		this.i = random.nextDouble() * 2 - 1;
		this.j = random.nextDouble() * 2 - 1;

		double m = Math.sqrt(this.i * this.i + this.j * this.j);

		this.i = this.i / m;
		this.j = this.j / m;

		super.onSceneActivated();
	}

	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
	}

	@Override
	public void update(DeltaState deltaState) {
		double advanced = this.speed * deltaState.getDelta();

		this.move(this.i * advanced, this.j * advanced);
		
		if(this.getX() <= 0 || this.getX() >= (this.getGame().getDisplayWidth() - (this.radius * 2))){
			this.i = - this.i;
		}
		
		if(this.getY() <= 0 || this.getY() >= (this.getGame().getDisplayHeight()- (this.radius * 2))){
			this.j = - this.j;
		}		

		super.update(deltaState);
	}

}
