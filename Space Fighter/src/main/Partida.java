package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.annotation.Generated;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sound.Sound;

public class Partida extends Window{
	private Game game;
	private int intervaloEnemigos =2000;
	private long tiempoAnterior;


	public Partida(Game game, int dificultad){
		Image img=null;
		this.game = game;
		//Easy
		if(dificultad == 0 ){
			img = ImageLoader.loadImage("Imagenes/background easy (2).jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			Sound s = new Sound("MUSICA/[Electro_-_Arion_-_Cold_Blood_and_Ice_Cream_Cones_.wav", 1);
			s.start();
		}

		//Medium
		if(dificultad == 1 ){
			img = ImageLoader.loadImage("Imagenes/background medio3.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			Sound s2 = new Sound("MUSICA/Jetta_-_I_39_d_Love_to_Change_the_World_Matstubs_R.wav", 1);
			s2.start();
		}

		//Dificil
		if(dificultad == 2 ){
			img = ImageLoader.loadImage("Imagenes/background hard.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			Sound s3 = new Sound("MUSICA/K-391_-_Summertime_[Sunshine_.wav", 1);
			s3.start();
		}

		//Impossible
		if(dificultad == 3 ){
			img = ImageLoader.loadImage("Imagenes/background_imposible.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			Sound s4 = new Sound("MUSICA/Two_Steps_From_Hell_-_SkyWorld_SkyWorld_.wav", 1);
			s4.start();
		}

		setBackgroundImage(img);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);

		setVisible(true);

		Nave nave = new Nave( this);
		addSprite(nave);

	}

	@Override
	public void onKeyPress(int keyCode) {
		super.onKeyPress(keyCode);
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.showMainMenu();
		}
	}

	@Override
	protected void act() {
		super.act();
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		if(tiempoAnterior == 0){
			tiempoAnterior = tiempoActual;
			return;
		}
		
		if(tiempoTranscurrido > intervaloEnemigos){
			Enemigo e = new EnemigoSoldado(this);
			addSprite(e);
			float y = (float) (Math.random() * (Game.HEIGHT - e.getHeight()));
			e.setPosition(Game.WIDTH, y);
			tiempoAnterior = tiempoActual;
		}
	}












}
