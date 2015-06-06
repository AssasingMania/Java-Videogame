package main;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;

public class ArmaLaserBoss extends Arma{

	private Window window;
	
	public ArmaLaserBoss(Window w){
		window = w;
	}
	
	
	
	@Override
	public void shoot(Point2f pos) {
		//Boss
		LaserEnemigo l = new LaserEnemigo(window);
		l.setPosition(pos.x+250, pos.y+50);
		LaserEnemigo l2 = new LaserEnemigo(window);
		l2.setPosition(pos.x+250, pos.y+560);
		
		
	}
	
	

}
