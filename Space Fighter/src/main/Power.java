package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Power extends Window{

	private Game game;
	
	public Power(Game game){
		this.game = game;
		Image backgroundPower = ImageLoader.loadImage("Imagenes2/power background.jpg");
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);
		backgroundPower = backgroundPower.getScaledInstance(Game.HEIGHT, Game.WIDTH, Image.SCALE_SMOOTH);
		setBackgroundImage(backgroundPower);
	}
	
	
	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.showTienda();
		}


	}
	
	
}
