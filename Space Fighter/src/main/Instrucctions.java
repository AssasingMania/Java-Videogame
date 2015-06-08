package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Instrucctions extends Window{

	private Game game;
	
	public Instrucctions(Game game) {
		this.game = game;
		Image img = ImageLoader.loadImage("Imagenes2/lololololololololololololololololololololololol2.jpg");	
		img = img.getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(img);
		setWidth(Game.WIDTH);
		setHeight(Game.HEIGHT);
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.showMainMenu();
		}
		super.onKeyPress(keyCode);
	}
	
	

}
