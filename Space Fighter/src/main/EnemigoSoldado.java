package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class EnemigoSoldado extends Enemigo{


	private Window window;




	public EnemigoSoldado(Window window){
		this.window = window;
		Image img = ImageLoader.loadImage("Imagenes/navee.png").getScaledInstance(Game.WIDTH/20, Game.HEIGHT/20, Image.SCALE_SMOOTH);
		setImage(img);
		setVisible(true);
		setSpeed(new Vector2f(-1,0));
	}


	@Override
	public void move() {
		
	}

}
