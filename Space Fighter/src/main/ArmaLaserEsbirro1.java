package main;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;

public class ArmaLaserEsbirro1 extends Arma{

	private Window window;
	
	public ArmaLaserEsbirro1(Window w){
		window = w;
	}
	
	
	
	@Override
	public void shoot(Point2f pos) {
		LaserEnemigo l = new LaserEnemigo(window);
		l.setPosition(pos.x+100, pos.y+130);
		
	}
	
	

}
