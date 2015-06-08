package main;

import java.awt.Image;

import es.techtalents.ttgdl.image.ImageLoader;

public class ShipConfiguration {

	private Image img = ImageLoader.loadImage("Imagenes/spaceshipY.png");
	private Arma arma = new ArmaLaser(null);

	public ShipConfiguration(){
		img = img.getScaledInstance(Game.WIDTH/10, Game.HEIGHT/5, Image.SCALE_SMOOTH);
	}

	public ShipConfiguration(Image img){
		this.img = img;
	}

	public Image getImage() {
		return img;
	}
	
	public void setImage(Image img) {
		this.img = img;
	}

	public Arma getArma() {
		return arma ;
	}
	
	

}
