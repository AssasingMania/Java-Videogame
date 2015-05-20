package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Partida extends Window{
	private Game game;


	public Partida(Game game, int dificultad){
		Image img=null;
		this.game = game;
		//Easy
		if(dificultad == 0 ){
			img = ImageLoader.loadImage("Imagenes/background easy (2).jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		}

		//Medium
		if(dificultad == 1 ){
			img = ImageLoader.loadImage("Imagenes/background medio3.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);;
		}

		//Dificil
		if(dificultad == 2 ){
			img = ImageLoader.loadImage("Imagenes/background hard.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);;
		}
		
		//Impossible
		if(dificultad == 3 ){
			img = ImageLoader.loadImage("Imagenes/background_imposible.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);;
		}
		
		setBackgroundImage(img);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		
		setVisible(true);
		
		Nave nave = new Nave();
		addSprite(nave);

	}

	@Override
	public void onKeyPress(int keyCode) {
		super.onKeyPress(keyCode);
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.showMainMenu();
		}
	}












}
