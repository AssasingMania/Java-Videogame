package main;

import es.techtalents.ttgdl.gui.MainWindow;

public class Game extends MainWindow{

	private MenuPrincipal menuPrincipal = new MenuPrincipal(this);
	private MenuNivel nivel = new MenuNivel(this);
	private Tienda tienda = new Tienda(this);
	private Partida partida;
	private Instrucctions instrucctions = new Instrucctions(this);

	public Game(){
		showMainMenu();
	}

	public void showNivel() {
		removeWindow(menuPrincipal);
		removeWindow(tienda);
		if(partida != null){
			removeWindow(partida);
		}
		addWindow(nivel);
		nivel.setVisible(true);

	}

	public void showTienda() {
		removeWindow(menuPrincipal);
		if(partida != null){
			removeWindow(partida);
		}
		removeWindow(nivel);
		addWindow(tienda);
		tienda.setVisible(true);

	}

	public void showMainMenu() {
		removeWindow(nivel);
		removeWindow(tienda);
		if(partida != null){
			removeWindow(partida);
		}
		addWindow(menuPrincipal);
		menuPrincipal.setVisible(true);

	}

	public void showPartida(int dificultad) {
		partida = new Partida(this, dificultad);
		removeWindow(nivel);
		removeWindow(tienda);
		removeWindow(menuPrincipal);
		addWindow(partida);
		partida.setVisible(true);
	}
	public void showInstrucctions() {
		removeWindow(menuPrincipal);
		removeWindow(tienda);
		if(partida != null){
			removeWindow(partida);
		}
		removeWindow(nivel);
		addWindow(instrucctions);
		instrucctions.setVisible(true);
	}
}

