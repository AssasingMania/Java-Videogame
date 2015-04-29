package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Pelota extends Sprite{

	Vector2f speed = new Vector2f(2,-2);
	private Raqueta r;
	private Ladrillos l;
	private MainWindow w;
	private Window ventanaJuego;
	boolean muerto = false;

	public Pelota(Raqueta r, Ladrillos l, MainWindow w, Window ventanaJuego) {
		Image img = ImageLoader.loadImage("Images/fire-ball-png.png");
		setImage(img.getScaledInstance(MainWindow.WIDTH/30, MainWindow.WIDTH/30, Image.SCALE_SMOOTH));
		setPosition(MainWindow.WIDTH/2 - getWidth()/2, r.getPosition().y-getHeight());
		this.r = r;
		this.l = l;
		this.w = w;
		this.ventanaJuego = ventanaJuego;
	}

	@Override
	public void act() {
		if(r.checkCollision(this)){
			speed.y= speed.y * -1;
		}
		getPosition().add(speed);


		//RAQUETA

		//DERECHA
		if(getPosition().x >  MainWindow.WIDTH - getWidth() ){
			speed.x= speed.x * -1;
		}
		//ABAJO
		if(getPosition().y >  MainWindow.HEIGHT - getWidth() ){
			//speed.y= speed.y * -1;
			gameOver();
		}
		//ARRIBA
		if(getPosition().y < 0){
			speed.y= speed.y * -1;
		}
		//IZQUIERDA
		if(getPosition().x < 0){
			speed.x= speed.x * -1;
		}

		//LADRILLOS

		if(l.checkCollision(this)){
			speed.y= speed.y * -1;
		}

		if(getPosition().y < 0){

		}










	}

	private void gameOver() {
		if(!muerto){
			w.removeWindow(ventanaJuego);
			Window ventanagameover = new Window(){

				@Override
				public void onKeyPress(int keyCode) {
					if(keyCode == KeyEvent.VK_ESCAPE){
						System.exit(0);
					}
				}
				
			};
			ventanagameover.setHeight(MainWindow.HEIGHT);
			ventanagameover.setWidth(MainWindow.WIDTH);
			Image backgroundgameover = ImageLoader.loadImage("Images/Gameover.jpg");
			backgroundgameover = backgroundgameover.getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
			ventanagameover.setBackgroundImage(backgroundgameover);
			ventanagameover.setVisible(true);
			w.addWindow(ventanagameover);
			muerto = true;
		}

	}
     public void KeyPressed(int keyCode) {
		if(muerto){
			if(keyCode == KeyEvent.VK_ESCAPE){
				System.exit(0);
			}	
		}

	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub

	}



}
