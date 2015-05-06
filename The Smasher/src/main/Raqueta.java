package main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Raqueta extends Sprite{

	private boolean moveRight;
	private boolean moveLeft;
	int vx = 3;
	private List<Ladrillo> lista;

	public Raqueta(List<Ladrillo> lista) {

		Image img = ImageLoader.loadImage("Images/RaquetaRoja999999.png");
		img = img.getScaledInstance(MainWindow.WIDTH/7, MainWindow.HEIGHT/28, Image.SCALE_SMOOTH);
		setImage(img);
		setPosition(MainWindow.WIDTH/2 - getWidth()/2, MainWindow.HEIGHT - getHeight()/2);
		this.lista = lista;
	}

	@Override
	public void act() {
		if(moveLeft == true && getPosition().x > 0){
			Point2f pos = super.getPosition();
			pos.add(-vx , 0);
		}
		if(moveRight ==  true && getPosition().x < MainWindow.WIDTH - getWidth()){
			Point2f pos = super.getPosition();
			pos.add(+vx , 0);
		}

		//COMPROBAR COLISION CON LADRILLOS
		for(Ladrillo l : lista){
			if(l.checkCollision(this)){
				System.out.println("me he comido un ladrillo");
				powerUp();
				lista.remove(l);
				break;
			}
		}

	}

	private void powerUp() {
		double chooser = Math.random();
		if(chooser > 0.0 && chooser < 0.2){
			Image img = getImage().getScaledInstance(getImage().getWidth(null) + 50, getImage().getHeight(null), Image.SCALE_SMOOTH);
			setImage(img);
		}else if(chooser > 0.2 && chooser < 0.4){
			Image img = getImage().getScaledInstance(getImage().getWidth(null) - 50, getImage().getHeight(null), Image.SCALE_SMOOTH);
			setImage(img);
		}
		
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			moveRight = true;
		}
		if(keyCode == KeyEvent.VK_LEFT){
			moveLeft = true;
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

	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub

	}


}
