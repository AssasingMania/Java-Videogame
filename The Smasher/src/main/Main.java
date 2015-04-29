package main;

import java.awt.Image;
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
		
		Ladrillos l = new Ladrillos();
		l.setVisible(true);
		ventana.addSprite(l);
		
		Pelota p = new Pelota(r, l, w, ventana);
		p.setVisible(true);
		ventana.addSprite(p);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
