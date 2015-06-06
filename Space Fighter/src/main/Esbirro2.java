package main;

import java.awt.Image;
import java.awt.image.BufferedImage;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Esbirro2 extends Enemigo{


	private long tiempoAnterior;
	private Window window;
	private BufferedImage img;
	private BufferedImage imgR;


	public Esbirro2(Window window){
		this.window = window;
		img = ImageLoader.loadImage("Imagenes/IMAGENES/esbirro2.png");
		imgR = ImageLoader.loadImage("Imagenes/IMAGENES/esbirro2R.png");
		setImage(img);
		setVisible(true);
		setPosition(Game.WIDTH-Game.WIDTH/3, Game.HEIGHT/2);
		setSpeed(new Vector2f(-400,00));
		 
	}



	@Override
	public void move() {
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		tiempoAnterior = tiempoActual;

		float tiempoEnSec = tiempoTranscurrido/1000.0f;

		Vector2f speed = new Vector2f(getSpeed().x, getSpeed().y).mul(tiempoEnSec);
		getPosition().add(speed);
		getPosition().y = (float) (Game.HEIGHT/2 -getHeight()/2 + Math.cos(getPosition().x/100)*(Game.HEIGHT-getWidth())/2);
		if(getPosition().x < 0 - getWidth()){
			setPosition(Game.WIDTH, getPosition().y);
			
		}
		
		

	}


	@Override
	public void onColision(Sprite s) {
		if(s instanceof Laser){
			setPuntosDeVida(getPuntosDeVida()-1);
			if(isDead()){
				Point2f pos = new Point2f(getPosition()); 
				Sprite explosion = new Explosion(window, pos.add(getWidth()/2, getHeight()/2)); 
				window.addSprite(explosion);
				((Partida) window).removeEnemy(this);
			}
		}

	}
}
