package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Pelota extends Sprite{

	Vector2f speed = new Vector2f(1,-1);
	
	
	public Pelota(Raqueta r) {
		Image img = ImageLoader.loadImage("Images/Lol-face.gif");
	    setImage(img.getScaledInstance(MainWindow.WIDTH/30, MainWindow.WIDTH/30, Image.SCALE_SMOOTH));
		setPosition(MainWindow.WIDTH/2 - getWidth()/2, r.getPosition().y-getHeight());
		 
	
	}
	
	@Override
	public void act() {
		getPosition().add(speed);
		
		
		//DERECHA
		if(getPosition().x >  MainWindow.WIDTH - getWidth() ){
			speed.x= speed.x * -1;
		}
		//ABAJO
		if(getPosition().y >  MainWindow.HEIGHT - getWidth() ){
			speed.y= speed.y * -1;
		}
		//ARRIBA
		if(getPosition().y < 0){
			speed.y= speed.y * -1;
		}
		//IZQUIERDA
		if(getPosition().x < 0){
			speed.x= speed.x * -1;
		}
	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
