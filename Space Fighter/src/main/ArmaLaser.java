package main;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;

public class ArmaLaser extends Arma{

	
	public ArmaLaser(Window w){
		window = w;
	}
	
	@Override
	public void shoot(Point2f pos) {
		Laser l = new Laser(window);
		l.setPosition(pos.x+250, pos.y+100);
		
	}

}
