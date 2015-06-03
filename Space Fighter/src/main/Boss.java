package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Boss extends Enemigo{
	private Window window;
	private long tiempoAnterior;




	public Boss(Window window){
		this.window = window;
		Image img = ImageLoader.loadImage("Imagenes/POSIBLISIMA NAVE ENEMIGA.png");//.getScaledInstance(Game.WIDTH/10, Game.HEIGHT/10, Image.SCALE_SMOOTH);
		setImage(img);
		setVisible(true);
		setPosition(Game.WIDTH-Game.WIDTH/3, Game.HEIGHT/2);
		setSpeed(new Vector2f(-300,-300));
		setPuntosDeVida(10); 
	}
	
	
	
	@Override
	public void move() {
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		tiempoAnterior = tiempoActual;
		
		float tiempoEnSec = tiempoTranscurrido/1000.0f;
		
		Vector2f speed = new Vector2f(getSpeed().x, getSpeed().y).mul(tiempoEnSec);
		getPosition().add(speed);
		
		if(getPosition().x < Game.WIDTH/2){
			getSpeed().x *= -1;
			setPosition(Game.WIDTH/2, getPosition().y);
		}
		if(getPosition().x > Game.WIDTH-getWidth()){
			getSpeed().x *= -1;
			setPosition(Game.WIDTH-getWidth(), getPosition().y);
		}
		if(getPosition().y < 0){
			getSpeed().y *= -1;
			setPosition(getPosition().x, 0);
		}
		if(getPosition().y > Game.HEIGHT-getHeight()){
			getSpeed().y *= -1;
			setPosition(getPosition().x, Game.HEIGHT-getHeight());
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
