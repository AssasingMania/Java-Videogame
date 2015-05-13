package main;

import es.techtalents.ttgdl.gui.MainWindow;

public class Game extends MainWindow{

	private MenuPrincipal menuPrincipal = new MenuPrincipal(this);
	private MenuNivel nivel = new MenuNivel(this);
	private Tienda tienda = new Tienda(this);
	private Partida partida;

	public Game(){
		showMainMenu();
	}

	public void showNivel() {
		removeWindow(menuPrincipal);
		addWindow(nivel);
		nivel.setVisible(true);

	}

	public void showTienda() {
		removeWindow(menuPrincipal);
		addWindow(tienda);
		tienda.setVisible(true);

	}

	public void showMainMenu() {
		removeWindow(nivel);
		addWindow(menuPrincipal);
		menuPrincipal.setVisible(true);

	}

	public void showPartida(int dificultad) {
		partida = new Partida(this, dificultad);
		removeWindow(nivel);
		addWindow(partida);
		partida.setVisible(true);
	}
}
