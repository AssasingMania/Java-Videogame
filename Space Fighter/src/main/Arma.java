package main;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;

public abstract class Arma{
	
	
	private long tiempoAnterior;
	private long tiempoDeRecarga;
	protected Window window;
	
	
	public abstract void shoot(Point2f pos);
	
	public boolean canShoot(){
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		
		if(tiempoTranscurrido > tiempoDeRecarga){
			tiempoAnterior = tiempoActual;
		}
		
		return tiempoTranscurrido > tiempoDeRecarga;
		
	}
	
	public void setWindow(Window w){
		this.window = w;
	}
	
	public void setTiempoDeRecarga(int t){
		tiempoDeRecarga = t;
	}
	
	
}
