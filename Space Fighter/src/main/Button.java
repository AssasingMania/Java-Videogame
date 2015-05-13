package main;

import java.awt.Image;

import es.techtalents.ttgdl.sprite.Sprite;

public abstract class Button extends Sprite{
	
	
	private Image img1;
	private Image img2;
	
	public Button(Image img1, Image img2) {
		this.img1 = img1;
		this.img2 = img2;
		setImage(img1);
		
		
	}
	
	
	
	public void act() {
		
	}



	@Override
	public void onMouseEntered() {
		setImage(img2);
	}



	@Override
	public void onMouseExited() {
		setImage(img1);
	}



	@Override
	public boolean onClick(float x, float y) {
		click();
		return super.onClick(x, y);
	}



	public abstract void click();
	
	
	

}
