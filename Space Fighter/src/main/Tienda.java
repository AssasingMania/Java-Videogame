package main;

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
}


