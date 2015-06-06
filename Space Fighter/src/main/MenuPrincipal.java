package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;



public class MenuPrincipal extends Window{

	private Game game;
	public MenuPrincipal(Game game) {
		this.game = game;
		setWidth(Game.WIDTH);
		setHeight(Game.HEIGHT);
		Image backgroundMenuPrincipal = ImageLoader.loadImage("Imagenes/background easy.jpg");
		backgroundMenuPrincipal =backgroundMenuPrincipal.getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(backgroundMenuPrincipal);
		crearBotones();
	}

	private void crearBotones() {

		//JUGAR
		Image jugar1 = ImageLoader.loadImage("buttons/jugar1.png");
		Image jugar2 = ImageLoader.loadImage("buttons/jugar2.png");
		Button botonJugar = new Button(jugar1, jugar2){

			@Override
			public void click() {
				game.showNivel();
				
			}

		};
		float hBoton = botonJugar.getHeight();
		float btSp = 10;
		float hMenu = hBoton*4 + btSp;
		float x = Game.WIDTH/2 - botonJugar.getWidth()/2;
		float y = Game.HEIGHT/2 - hMenu/2;

		botonJugar.setPosition(x, y);
		botonJugar.setVisible(true);
		botonJugar.setEnabled(true);
		addSprite(botonJugar);

		//TIENDA
		Image tienda1 = ImageLoader.loadImage("buttons/tienda1.png");
		Image tienda2 = ImageLoader.loadImage("buttons/tienda2.png");
		Button botonTienda = new Button(tienda1, tienda2){

			@Override
			public void click() {
				game.showTienda();
			}

		};
		y = y + hBoton+btSp;
		x = Game.WIDTH/2 - botonTienda.getWidth()/2;
		botonTienda.setPosition(x, y);
		botonTienda.setVisible(true);
		botonTienda.setEnabled(true);
		addSprite(botonTienda);

		//EXIT
		Image exit1 = ImageLoader.loadImage("buttons/exit1.png");
		Image exit2 = ImageLoader.loadImage("buttons/exit2.png");
		Button botonExit = new Button(exit1, exit2){

			@Override
			public void click() {
				System.exit(0);
			}

		};
		y = y + hBoton + btSp;
		x = Game.WIDTH/2 - botonExit.getWidth()/2;
		botonExit.setPosition(x, y);
		botonExit.setVisible(true);
		botonExit.setEnabled(true);
		addSprite(botonExit);
		
		//Instruccionnes
		Image instrucctions1 = ImageLoader.loadImage("buttons/instrucctions1.png");
		Image instrucctions2 = ImageLoader.loadImage("buttons/instrucctions2.png");
		Button botonInstucctions = new Button(instrucctions1, instrucctions2){

			@Override
			public void click() {
				game.showInstrucctions();
			}

		};
		y = y + hBoton + btSp;
		x = Game.WIDTH/2 - botonInstucctions.getWidth()/2;
		botonInstucctions.setPosition(x, y);
		botonInstucctions.setVisible(true);
		botonInstucctions.setEnabled(true);
		addSprite(botonInstucctions);
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);	
		}


	}


} 
