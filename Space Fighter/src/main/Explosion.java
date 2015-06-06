package main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sound.Sound;
import es.techtalents.ttgdl.sprite.Sprite;

public class Explosion extends Sprite{

	private static List<Image> images = loadImages();
	//private static Sound sound = new Sound("MUSICA/explosion.wav",3);
	private long tiempoAnterior;
	private Window window;
	private float animationDuration = 1.0f;
	
	public Explosion(Window w, Point2f pos){
		this.window = w;
		pos.add(-images.get(15).getWidth(null), -images.get(15).getHeight(null)/2);
		setImage(images.get(0));
		setPosition(pos);
		setVisible(true);
	}
	
	
	
	@Override
	public void act() {
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		if(tiempoAnterior == 0){
			//sound.start();
			tiempoAnterior = tiempoActual;
			return;
		}
		float tiempoEnSec = tiempoTranscurrido/1000.0f;
		int numFrames = images.size();
		
		int frameActual = (int) ((tiempoEnSec/animationDuration)*numFrames);
		if(frameActual >= numFrames){
			window.removeSprite(this);
			return;
		}
		setImage(images.get(frameActual));
	}



	private static List<Image> loadImages(){
		ArrayList<Image> images = new ArrayList<>();
		for(int i = 0;i<25;i++){
			String path = "explosiones/explosion"+i+".png";
			Image img = ImageLoader.loadImage(path).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			images.add(img);
		}
		
		return images;
	}




}