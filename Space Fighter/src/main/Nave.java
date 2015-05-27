package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Nave extends Sprite{
	
	private Window p;

	private Vector2f speed = new Vector2f(0, 0);
	
	private boolean moveRight;
	private boolean moveLeft;
	private boolean moveUp;
	private boolean moveDown;
	private Arma a;

	private long tiempoAnterior;

	private boolean shooting;

	public Nave(Window w){
		this.p = w;
		a = new ArmaLaser(p);
		a.setTiempoDeRecarga(250);
		Image imgNave = ImageLoader.loadImage("Imagenes/spaceshipY.png");
		imgNave = imgNave.getScaledInstance(Game.WIDTH/15, Game.HEIGHT/5, Image.SCALE_SMOOTH);
		setImage(imgNave);
		setVisible(true);

	}




	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_RIGHT){
			moveRight = true;
		}

		if(keyCode == KeyEvent.VK_LEFT){
			moveLeft = true;
		}

		if(keyCode == KeyEvent.VK_UP){
			moveUp = true;
		}

		if(keyCode == KeyEvent.VK_DOWN){
			moveDown = true;
		}

		if(keyCode == KeyEvent.VK_SPACE){
			shooting = true;
		}




	}

	private void shoot() {
		if(a.canShoot()){
			a.shoot(getPosition());
		}

	}




	@Override
	public void onKeyReleased(int keyCode) {
		if(keyCode == KeyEvent.VK_RIGHT){
			moveRight = false;
		}

		if(keyCode == KeyEvent.VK_LEFT){
			moveLeft = false;
		}

		if(keyCode == KeyEvent.VK_UP){
			moveUp = false;
		}

		if(keyCode == KeyEvent.VK_DOWN){
			moveDown = false;
		}
		if(keyCode == KeyEvent.VK_SPACE){
			shooting = false;
		}
	}




	@Override
	public void act() {
		if(shooting){
			shoot();
		}
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		tiempoAnterior = tiempoActual;

		float tiempoEnSec = tiempoTranscurrido/1000.0f;

		if(moveRight){
			speed.x = 750;
		}else if(moveLeft){
			speed.x = -750;
		}else{
			speed.x = 0;
		}

		if(moveDown){
			speed.y = 750;
		}else if(moveUp){
			speed.y = -750;
		}else{	
			speed.y = 0;	
		}
		
		//para q si lo esquivas vuelve a donde empezo (E.S.)
		getPosition().add(speed.mul(tiempoEnSec));
		
		Point2f pos = getPosition();
		if(pos.x < 0){
			pos.x = 0;
		}
		
		if(pos.y < 0){
			pos.y = 0;
		}
		
		if(pos.x > Game.WIDTH - getWidth()){
			pos.x = Game.WIDTH - getWidth();
		}
		
		if(pos.y > Game.HEIGHT - getHeight()){
			pos.y = Game.HEIGHT - getHeight();
		}
		
		

	}
}
