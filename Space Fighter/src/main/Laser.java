package main;

import java.awt.Image;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Laser extends Sprite{

	private Window window;
	private long tiempoAnterior;
	private float speed = 1500;
	
	public Laser(Window w){
		this.window = w;
		Image img = ImageLoader.loadImage("Imagenes/bala_aliada2.png");
		setImage(img);
		setVisible(true);
		w.addSprite(this);
		
	}
	
	@Override
	public void act() {
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		
		if(tiempoAnterior == 0){
			tiempoAnterior = tiempoActual;
			return;
		}
		tiempoAnterior = tiempoActual;
		
		float tiempoEnSec = tiempoTranscurrido/1000.0f;
		
		getPosition().x += speed * tiempoEnSec;
		
		if(getPosition().x > Game.WIDTH - getWidth()){
			 window.removeSprite(this);
		}
	}

}
