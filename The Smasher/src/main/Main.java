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
		Image background = ImageLoader.loadImage("Images/yeah.jpg");
		background = background.getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
		ventana.setBackgroundImage(background);
		ventana.setVisible(true);
		w.addWindow(ventana);
		
		List<Ladrillo> lista = new ArrayList<Ladrillo>();
		
		Raqueta r = new Raqueta(lista);
		r.setVisible(true);
		ventana.addSprite(r);
		
		int numX = 9;
		int numY = 6;
		
		for(int i = 0; i < numX; i++){
			for(int j = 0; j < numY; j++){
				Ladrillo l = new Ladrillo(4,numX, numY);
				l.setVisible(true);
				ventana.addSprite(l);
				lista.add(l);
				l.setPosition(i*(l.getWidth()+7),j*l.getHeight());
				
				
				
			}
			
		}
		
		
		
		Pelota p = new Pelota(r, w, ventana, lista);
		p.setVisible(true);
		ventana.addSprite(p);
		
		
		
		
		
		
		
	}

}
