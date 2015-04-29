package main;

import java.awt.Image;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Ladrillos extends Sprite{

	

	public Ladrillos() {
		Image img = ImageLoader.loadImage("Images/RaquetaNv1.png");
		setImage(img);
		
	}

	@Override
	public void act() {


	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub

	}

}
