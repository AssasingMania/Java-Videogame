package main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Pelota extends Sprite{

	private static final boolean DEBUG = false;
	Vector2f speed = new Vector2f(1,-1);
	private Raqueta r;
	private MainWindow w;
	private Window ventanaJuego;
	boolean muerto = false;
	private List<Ladrillo> lista;
	private int numLadrillos;

	public Pelota(Raqueta r, MainWindow w, Window ventanaJuego, List<Ladrillo> lista) {
		Image img = ImageLoader.loadImage("Images/mirai_fireball.gif");
		setImage(img.getScaledInstance(MainWindow.WIDTH/30, MainWindow.WIDTH/30, Image.SCALE_SMOOTH));
		setPosition(MainWindow.WIDTH/2 - getWidth()/2, r.getPosition().y-getHeight());
		this.r = r;
		this.w = w;
		this.ventanaJuego = ventanaJuego;
		this.lista = lista;
		numLadrillos = lista.size();

	}

	@Override
	public void act() {
		if(r.checkCollision(this)){
			speed.y = -1;
		}

		getPosition().add(speed);


		//RAQUETA

		//DERECHA
		if(getPosition().x >  MainWindow.WIDTH - getWidth() ){
			speed.x= speed.x * -1;
		}
		//ABAJO
		if(getPosition().y >  MainWindow.HEIGHT - getWidth() ){
			if(DEBUG){
				speed.y= speed.y * -1;
			}else{
				gameOver();
			}

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
		for(Ladrillo l : lista){
			if(l.checkCollision(this) && !l.isDead()){
				speed.y = speed.y * -1;

				l.onColision(this);
				if(l.isDead()){
					numLadrillos = numLadrillos -1;
				}

				break;
			}
		}
		if(numLadrillos == 0){
			youWon();
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








	private void youWon(){


		w.removeWindow(ventanaJuego);

		Window ventanayouwon1 = new Window(){

			@Override
			public void onKeyPress(int keyCode) {
				if(keyCode == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
				super.onKeyPress(keyCode);
			}

		};
		ventanayouwon1.setHeight(MainWindow.HEIGHT);
		ventanayouwon1.setWidth(MainWindow.WIDTH);
		Image backgroundyouwon = ImageLoader.loadImage("Images/you wonjajjajaja.jpg");
		backgroundyouwon = backgroundyouwon.getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
		ventanayouwon1.setBackgroundImage(backgroundyouwon);
		ventanayouwon1.setVisible(true);
		w.addWindow(ventanayouwon1);


	}
	public void KeyPressed1(int keyCode) {

		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}

	}

	@Override
	public void onColision(Sprite sprite) {

		if(sprite instanceof Ladrillo){
			speed.y = speed.y * -1;
			sprite.onColision(this);
		}

	}



}
