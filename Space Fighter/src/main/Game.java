package main;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;

public class Game extends MainWindow{

	private MenuPrincipal menuPrincipal = new MenuPrincipal(this);
	private MenuNivel nivel = new MenuNivel(this);
	private Tienda tienda = new Tienda(this);
	private Partida partida;
	private Power power = new Power(this);
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
		removeWindow(power);
		addWindow(tienda);
		tienda.setVisible(true);
		
	}
	
	public void showPowers() {
		removeWindow(menuPrincipal);
		if(partida != null){
			removeWindow(partida);
		}
		removeWindow(nivel);
		removeWindow(tienda);
		addWindow(power);
		power.setVisible(true);

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
