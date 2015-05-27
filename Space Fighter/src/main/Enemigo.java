package main;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.sprite.Sprite;

public abstract class Enemigo extends Sprite{

	private Vector2f speed = new Vector2f(0, 0) ; 
	private int puntosDeVida = 100;
	
	
	@Override
	public void act() {
		move();
		
	}

	public abstract void move();

	
	
	
	public Vector2f getSpeed() {
		return speed;
	}

	public void setSpeed(Vector2f speed) {
		this.speed = speed;
	} 
		
	public boolean isDead(){
		if(puntosDeVida <= 0){
			return true;
		}
		return false;
	}
	
	public int getPuntosDeVida() {
		return puntosDeVida;
	}
	
	public void setPuntosDeVida(int puntosDeVida){
		this.puntosDeVida = puntosDeVida;
	}
	 
}
