package main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;







import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
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
	private int vidaBoss;
	private int vidaEsbirro1;
	private int vidaEsbirro2;
	private Esbirro1 esbirro1;
	private Esbirro2 esbirro2;
	private Vector2f velesbirro1;
	private Vector2f velesbirro2;
	private int tiempRecargaBoss;
	private int tiempRecargaEsbirro1;
	private Sound s;
	private Sound s2;
	private Image img;
	private Image img2;
	private boolean troll = false;
	private Sound s3;

	public Partida(Game game, int dificultad){
		img2=null;
		this.game = game;
		//Easy
		if(dificultad == 0 ){
			img2 = ImageLoader.loadImage("Imagenes/jiji.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			s = new Sound("MUSICA/SUPER_SMASH_BROS_RAP_-_KEYBLADE_-_ZARCORT_-_SHARKN.wav", 1);
			s.start();
			limiteEnemigos = 20;
			vidaBoss = 20;
			vidaEsbirro1 = 10;
			vidaEsbirro2 = 15;
			velesbirro1 = new Vector2f(-200,-200);
			velesbirro2 = new Vector2f(-300,-300);
			tiempRecargaBoss=900;
			tiempRecargaEsbirro1=1000;
			s2 =new Sound("MUSICA/DMX_-_Where_The_Hood_At_Dirty_HQ_mp3cut.wav", 1);
			s3 = new Sound("MUSICA/Game_Over_sound_effect.wav", 1);

		}

		//Medium
		if(dificultad == 1){
			img2 = ImageLoader.loadImage("Imagenes/IMAGENES/lol.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			s = new Sound("MUSICA/CALL_OF_DUTY_ADVANCED_WARFARE_-_ZARCORT_CYCLO_Y_PI.wav", 1);
			s.start();
			limiteEnemigos = 50;
			vidaBoss = 50;
			vidaEsbirro1 = 25;
			vidaEsbirro2 = 30;
			velesbirro1 = new Vector2f(-300,-300);
			velesbirro2 = new Vector2f(-400,-400);
			tiempRecargaBoss=700;
			tiempRecargaEsbirro1=900;
			s2 =new Sound("MUSICA/DMX_-_Where_The_Hood_At_Dirty_HQ_mp3cut.wav", 1);
			s3 = new Sound("MUSICA/Game_Over_sound_effect.wav", 1);
		}

		//Dificil
		if(dificultad == 2){
			img2 = ImageLoader.loadImage("Imagenes/IMAGENES/background hard.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			s = new Sound("MUSICA/BLOODBORNE_EPIC_RAP_-_ZARCORT.wav", 1);
			s.start();
			limiteEnemigos = 100;
			vidaBoss = 100;
			vidaEsbirro1 = 50;
			vidaEsbirro2 = 55;
			velesbirro1 = new Vector2f(-400,-400);
			velesbirro2 = new Vector2f(-500,-500);
			tiempRecargaBoss=600;
			tiempRecargaEsbirro1=850;
			s2 =new Sound("MUSICA/DMX_-_Where_The_Hood_At_Dirty_HQ_mp3cut.wav", 1);
			s3 = new Sound("MUSICA/Game_Over_sound_effect.wav", 1);
		}

		//Impossible
		if(dificultad == 3){
			img2 = ImageLoader.loadImage("Imagenes/IMAGENES/yeah.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			s = new Sound("MUSICA/JUEGO_DE_TRONOS_RAP_-_ZARCORT_Y_FER_-_PARODIA.wav", 1);
			s.start();
			limiteEnemigos = 2147483647;
			vidaBoss = 2147483647;
			vidaEsbirro1 = 1073741823;
			vidaEsbirro2 = 1073741828;
			velesbirro1 = new Vector2f(-700,-700);
			velesbirro2 = new Vector2f(-800,-800);
			tiempRecargaBoss=100;
			tiempRecargaEsbirro1=500;
			s2 =new Sound("MUSICA/DMX_-_Where_The_Hood_At_Dirty_HQ_mp3cut.wav", 1);
			s3 = new Sound("MUSICA/Game_Over_sound_effect.wav", 1);
		}   

		setBackgroundImage((Image) img2);
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
			s.stopAll();
			s2.stopAll();
			s3.stopAll();
		}

	}

	@Override
	protected void act() {
		if(troll == true){
			limiteEnemigos = 0;
			vidaBoss = 5;
			vidaEsbirro1 = 5;
			vidaEsbirro2 = 1;

		}
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
		}else if(numEnemigos >= limiteEnemigos && enemigos.isEmpty() && esbirro1 == null){
			esbirro1 = new Esbirro1(this);
			esbirro1.setSpeed(new Vector2f(-300,-300));
			addSprite(esbirro1);
			esbirro1.setPuntosDeVida(vidaEsbirro1);
			esbirro1.setTiempoDeRecarga(tiempRecargaEsbirro1);
			enemigos.add(esbirro1);
		}else if(numEnemigos >= limiteEnemigos && enemigos.isEmpty() && esbirro1 != null && esbirro2 == null){
			esbirro2 = new Esbirro2(this);
			esbirro2.setSpeed(new Vector2f(-400,00));
			addSprite(esbirro2);
			esbirro2.setPuntosDeVida(vidaEsbirro2);
			enemigos.add(esbirro2);
		}else if(numEnemigos >= limiteEnemigos && enemigos.isEmpty() && esbirro1 != null && esbirro2 != null && boss == null){
			boss = new Boss(this);
			addSprite(boss);
			boss.setPuntosDeVida(vidaBoss);
			boss.setTiempoDeRecarga(tiempRecargaBoss);
			enemigos.add(boss);
		}
		if(boss !=  null && boss.isDead()){
			s.stopAll();
			s3.stopAll();
			s2.start();
			setBackgroundImage(ImageLoader.loadImage("Imagenes/IMAGENES/youwin.png"));
		}
		if(nave == null){
			s.stopAll();
			s3.start();
			setBackgroundImage(ImageLoader.loadImage("Imagenes2/gaem over.png"));
		}


	}

	private void comprobarColisiones() {
		if(nave != null){
			for(Enemigo e : enemigos){
				if(e.checkCollision(nave)){
					matarNave();
					return;

				}
			}
		}
	}

	public void matarNave() {
		if(nave!=null){
			Point2f pos = new Point2f(nave.getPosition());
			Sprite explosion = new Explosion(this, pos.add(nave.getWidth()/2, nave.getHeight()/2)); 
			this.addSprite(explosion);
			removeSprite(nave);
			nave = null;
		}
	}

	public List<Enemigo> getEnemigos(){
		return enemigos;

	}

	public void removeEnemy(Enemigo enemigo){
		enemigos.remove(enemigo);
		removeSprite(enemigo);
	}



	public Nave getNave() {
		return nave;
	}






}

