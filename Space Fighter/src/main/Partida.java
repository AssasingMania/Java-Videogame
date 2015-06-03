package main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;




import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sound.Sound;
import es.techtalents.ttgdl.sprite.Sprite;

public class Partida extends Window{
	private Game game;
	private int intervaloEnemigos = 1500;
	private long tiempoAnterior;
	private List<Enemigo> enemigos = new ArrayList<>();
	private Nave nave;
	private int numEnemigos;
	private int limiteEnemigos = 10;
	private Boss boss;


	public Partida(Game game, int dificultad){
		Image img=null;
		this.game = game;
		//Easy
		if(dificultad == 0 ){
			img = ImageLoader.loadImage("Imagenes/IMAGENES/2f3058_2959908.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			Sound s = new Sound("MUSICA/[Electro_-_Arion_-_Cold_Blood_and_Ice_Cream_Cones_.wav", 1);
			s.start();
			limiteEnemigos = 20;
		}

		//Medium
		if(dificultad == 1){
			img = ImageLoader.loadImage("Imagenes/IMAGENES/lol.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			Sound s2 = new Sound("MUSICA/Jetta_-_I_39_d_Love_to_Change_the_World_Matstubs_R.wav", 1);
			s2.start();
			limiteEnemigos = 50;
		}

		//Dificil
		if(dificultad == 2){
			img = ImageLoader.loadImage("Imagenes/IMAGENES/background hard.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			Sound s3 = new Sound("MUSICA/K-391_-_Summertime_[Sunshine_.wav", 1);
			s3.start();
			limiteEnemigos = 100;
		}

		//Impossible
		if(dificultad == 3){
			img = ImageLoader.loadImage("Imagenes/IMAGENES/yeah.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			Sound s4 = new Sound("MUSICA/Two_Steps_From_Hell_-_SkyWorld_SkyWorld_.wav", 1);
			s4.start();
			limiteEnemigos = 2147483647;
		}   

		setBackgroundImage(img);
		setHeight(Game.HEIGHT);
		setWidth(Game.WIDTH);

		setVisible(true);

		nave = new Nave(this);
		addSprite(nave);
		
		intervaloEnemigos = 1000 - dificultad*250;
		

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
		comprobarColisiones();
		super.act();
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		if(tiempoAnterior == 0){
			tiempoAnterior = tiempoActual;
			return;
		}

		if(tiempoTranscurrido > intervaloEnemigos && numEnemigos < limiteEnemigos){
			Enemigo e = new EnemigoSoldado(this);
			numEnemigos++;
			addSprite(e);
			enemigos.add(e);
			float y = (float) (Math.random() * (Game.HEIGHT - e.getHeight()));
			e.setPosition(Game.WIDTH, y);
			tiempoAnterior = tiempoActual;
		}else if(numEnemigos >= limiteEnemigos && boss == null && enemigos.isEmpty()){
			boss = new Boss(this);
			addSprite(boss);
			enemigos.add(boss);
		}
	}

	private void comprobarColisiones() {
		if(nave != null){
			for(Enemigo e : enemigos){
				if(e.checkCollision(nave)){
					Point2f pos = new Point2f(nave.getPosition());
					Sprite explosion = new Explosion(this, pos.add(nave.getWidth()/2, nave.getHeight()/2)); 
					this.addSprite(explosion);
					removeSprite(nave);
					nave = null;
					return;
					
				}
			}
		}
	}

	public List<Enemigo> getEnemigos(){
		return enemigos;

	}

	public void removeEnemy(Enemigo enemigo){
		enemigos.remove(enemigo);
		removeSprite(enemigo);
	}










}

