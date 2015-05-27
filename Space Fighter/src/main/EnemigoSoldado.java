package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class EnemigoSoldado extends Enemigo{


	private Window window;
	long tiempoAnterior;
	
	
	
	
	public EnemigoSoldado(Window window){
		this.window = window;
		Image img = ImageLoader.loadImage("Imagenes/navee.png").getScaledInstance(Game.WIDTH/10, Game.HEIGHT/10, Image.SCALE_SMOOTH);
		setImage(img);
		setVisible(true);
		setSpeed(new Vector2f(-600,0));
		setPuntosDeVida(1); 
	}


	@Override
	public void move() {
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		tiempoAnterior = tiempoActual;
		
		float tiempoEnSec = tiempoTranscurrido/1000.0f;
		
		Vector2f speed = new Vector2f(getSpeed().x, getSpeed().y).mul(tiempoEnSec);
		getPosition().add(speed);
		
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
