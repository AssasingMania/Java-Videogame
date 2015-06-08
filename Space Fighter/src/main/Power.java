package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Power extends Window{

	private Game game;
	private Image img1;
	public Power(Game game){
		this.game = game;
		Image backgroundPower = ImageLoader.loadImage("Imagenes2/power background.jpg");
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		backgroundPower = backgroundPower.getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(backgroundPower);
		crearBotones();
	}


	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.showTienda();
		}

	}
	
	
	
	
	private void crearBotones() {

		
		final Image img = ImageLoader.loadImage("Imagenes/POSIBLISIMA NAVE.png")
				.getScaledInstance(Game.WIDTH/20, (int) (Game.HEIGHT/10f), Image.SCALE_SMOOTH);
		
		Button botonPower = new Button(img,img){

			public void click() {
				
				ShipConfiguration configActual = Nave.getConfig();
				configActual.setImage(img);
				Nave.setConfig(configActual);
			}

		};
		float hBoton = botonPower.getHeight();
		float btSp = 10;
		float hMenu = hBoton*3 + btSp;
		float x = Game.WIDTH/2 - botonPower.getWidth()/2;
		float y = Game.HEIGHT/2 - hMenu/2;

		botonPower.setPosition(x, y);
		botonPower.setVisible(true);
		botonPower.setEnabled(true);
		addSprite(botonPower);






	}
	
}
