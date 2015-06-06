package main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;







public class Tienda extends Window{

	private Game game;
	

	public Tienda(Game game){
		this.game = game;
		setWidth(Game.WIDTH);
		setHeight(Game.HEIGHT);
		Image backgroundTienda = ImageLoader.loadImage("Imagenes/background tienda.png");
		backgroundTienda =backgroundTienda.getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(backgroundTienda);
		
		
		
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.showMainMenu();
		}


	}






	private void crearBotones() {
		//NAVES
		Image naves = ImageLoader.loadImage("buttons/naves.png");
		Image naves2 = ImageLoader.loadImage("buttons/naves2.png");
		Button botonNaves = new Button(naves, naves2){

			public void click() {
				System.exit(0);
			}

		};
		float hBoton = botonNaves.getHeight();
		float btSp = 10;
		float hMenu = hBoton*3 + btSp;
		float x = Game.WIDTH/2 - botonNaves.getWidth()/2;
		float y = Game.HEIGHT/2 - hMenu/2;

		botonNaves.setPosition(x, y);
		botonNaves.setVisible(true);
		botonNaves.setEnabled(true);
		addSprite(botonNaves);
		
		//POWERS
		Image powers = ImageLoader.loadImage("buttons/powers.png");
		Image powers2 = ImageLoader.loadImage("buttons/powers2.png");
		Button botonPower = new Button(powers, powers2){

			public void click() {
				System.exit(0);
			}

		};
		float hBoton2 = botonPower.getHeight();
		float btSp2 = 10;
		float hMenu2 = hBoton*3 + btSp;
		float x2 = Game.WIDTH/2 - botonPower.getWidth()/2;
		float y2 = Game.HEIGHT/2 - hMenu/2;

		botonPower.setPosition(x, y);
		botonPower.setVisible(true);
		botonPower.setEnabled(true);
		addSprite(botonPower);
	}
}



