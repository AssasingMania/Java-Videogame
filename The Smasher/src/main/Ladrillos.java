package main;

import java.awt.Image;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Ladrillos extends Sprite{

	Image img1 = ImageLoader.loadImage("Images/RaquetaNv1.png");
	Image img2 = ImageLoader.loadImage("Images/RaquetaNv2.png");
	Image img3 = ImageLoader.loadImage("Images/RaquetaNv3.png");
	Image img4 = ImageLoader.loadImage("Images/RaquetaNv4.png");
	Image img5 = ImageLoader.loadImage("Images/RaquetaNv5.png");
	Image img6 = ImageLoader.loadImage("Images/RaquetaNvSupremoJr.png");
	Image img7 = ImageLoader.loadImage("Images/RaquetaNvSupremo.png");
	
	private int vida = 7;
	
	
	public Ladrillos(int x, int y) {
		img1.getScaledInstance(MainWindow.WIDTH/x, MainWindow.HEIGHT/y, Image.SCALE_SMOOTH);
		
		setImage(img1);
		
	}

	@Override
	public void act() {
		

	}




	@Override
	public void onColision(Sprite arg0) {
		vida--;
		if(vida == 7){
			setImage(img1);
		}
		if(vida == 6){
			setImage(img2);
		}
		if(vida == 5){
			setImage(img3);
		}
		if(vida == 4){
			setImage(img4);
		}
		if(vida == 3){
			setImage(img5);
		}
		if(vida == 2){
			setImage(img6);
		}
		if(vida == 1){
			setImage(img7);
		}

	}

}
