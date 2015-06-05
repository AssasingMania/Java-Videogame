package main;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;

public class ArmaLaserEnemigo extends Arma{

	private Window window;
	
	public ArmaLaserEnemigo(Window w){
		window = w;
	}
	
	
	
	@Override
	public void shoot(Point2f pos) {
		LaserEnemigo l = new LaserEnemigo(window);
		l.setPosition(pos.x+250, pos.y+200);
		
	}

}
