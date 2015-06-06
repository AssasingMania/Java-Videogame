package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class MenuNivel extends Window{

	private Game game;
	
	public MenuNivel(Game game){
		this.game = game;
		setWidth(Game.WIDTH);
		setHeight(Game.HEIGHT);
		Image backgroundJugar = ImageLoader.loadImage("Imagenes/background easy (2).jpg");
		backgroundJugar =backgroundJugar.getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(backgroundJugar);
		crearBotones();
	}

	private void crearBotones() {

		//EASY
		Image easy1 = ImageLoader.loadImage("buttons/easy1.png");
		Image easy2 = ImageLoader.loadImage("buttons/easy2.png");
		Button botonEasy = new Button(easy1, easy2){

			@Override
			public void click() {
				game.showPartida(0);
			}

		};
		float hBoton = botonEasy.getHeight();
		float btSp = 10;
		float hMenu = hBoton*4 + btSp;
		float x = Game.WIDTH/2 - botonEasy.getWidth()/2;
		float y = Game.HEIGHT/2 - hMenu/2;

		botonEasy.setPosition(x, y);
		botonEasy.setVisible(true);
		botonEasy.setEnabled(true);
		addSprite(botonEasy);

		//Medium
		Image medium1 = ImageLoader.loadImage("buttons/medium1.png");
		Image medium2 = ImageLoader.loadImage("buttons/medium2.png");
		Button botonMedium = new Button(medium1, medium2){

			@Override
			public void click() {
				game.showPartida(1);
			}

		};
		y = y + hBoton+btSp;
		x = Game.WIDTH/2 - botonMedium.getWidth()/2;
		botonMedium.setPosition(x, y);
		botonMedium.setVisible(true);
		botonMedium.setEnabled(true);
		addSprite(botonMedium);
		
		//Hard
		Image hard1 = ImageLoader.loadImage("buttons/hard1.png");
		Image hard2 = ImageLoader.loadImage("buttons/hard2.png");
		Button botonHard = new Button(hard1, hard2){

			@Override
			public void click() {
				game.showPartida(2);
			}

		};
		y = y + hBoton + btSp;
		x = Game.WIDTH/2 - botonHard.getWidth()/2;
		botonHard.setPosition(x, y);
		botonHard.setVisible(true);
		botonHard.setEnabled(true);
		addSprite(botonHard);
		
		//Impossible
				Image impossible1 = ImageLoader.loadImage("buttons/impossible1.png");
				Image impossible2 = ImageLoader.loadImage("buttons/impossible2.png");
				Button botonImpossible = new Button(impossible1, impossible2){

					@Override
					public void click() {
						game.showPartida(3);
					}

				};
				y = y + hBoton + btSp;
				x = Game.WIDTH/2 - botonImpossible.getWidth()/2;
				botonImpossible.setPosition(x, y);
				botonImpossible.setVisible(true);
				botonImpossible.setEnabled(true);
				addSprite(botonImpossible);
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.showMainMenu();
		}


	}


	
	
}
