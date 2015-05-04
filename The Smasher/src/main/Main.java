package main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Main {

	public static void main(String[] args) {
		MainWindow w = new MainWindow();
		
		Window ventana = new Window();
		ventana.setHeight(MainWindow.HEIGHT);
		ventana.setWidth(MainWindow.WIDTH);
		Image background = ImageLoader.loadImage("Images/background3.jpg");
		background = background.getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
		ventana.setBackgroundImage(background);
		ventana.setVisible(true);
		w.addWindow(ventana);
		
		Raqueta r = new Raqueta();
		r.setVisible(true);
		ventana.addSprite(r);
		
		List<Ladrillo> lista = new ArrayList<Ladrillo>();
		
		int numX = 9;
		int numY = 4;
		
		for(int i = 0; i < numX; i++){
			for(int j = 0; j < numY; j++){
				Ladrillo l = new Ladrillo(7,numX, numY);
				l.setVisible(true);
				ventana.addSprite(l);
				lista.add(l);
				l.setPosition(i*(l.getWidth()+7),j*l.getHeight());
				
				
				
			}
			
		}
		
		
		
		Pelota p = new Pelota(r, w, ventana, lista);
		p.setVisible(true);
		ventana.addSprite(p);
		
		
		
		Window ventanayouwon = new Window();
		ventanayouwon.setHeight(MainWindow.HEIGHT);
		ventanayouwon.setWidth(MainWindow.WIDTH);
		Image backgroundyouwon = ImageLoader.loadImage("Images/background3.jpg");
		backgroundyouwon = backgroundyouwon.getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
		ventanayouwon.setBackgroundImage(backgroundyouwon);
		ventanayouwon.setVisible(true);
		
		
		
	}

}
