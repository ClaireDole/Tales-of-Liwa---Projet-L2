package fr.rpg.controler.observerpattern.concreteobserver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import fr.rpg.controler.RpgMain;
import fr.rpg.controler.observerpattern.Event;

/**
 * input flèche bas sur un écran de type GameScreen
 * gestion du mouvement du joueur lorsqu'il veut aller vers le haut
 * on vérifie s'il peut (sortie de la carte, obstacles)
 * puis on regarde s'il existe des collectibles à l'endroit où le joueur se déplace
 * si oui on gère la collecte du collectible
 * on déplace le joueur
 */
public class GameUp extends concreteobserver{

	public GameUp(String name) {
		super(name);
	}

	@Override
	public void update(Event event) {
		RpgMain game = event.getGame();
		if(event.compareTo(new Event(game,"GameScreen", true, "UP",null))==0) {
			Boolean valid = true;
			if (event.getEcran().getTiledmodel().getObstacles()!=null) {
				//obstacles
				for (int i = 0; i < event.getEcran().getTiledmodel().getObstacles().size(); i++) {
					int x = event.getEcran().getTiledmodel().getObstacles().get(i).Getx();
					int y = event.getEcran().getTiledmodel().getObstacles().get(i).Gety();
					if (x == game.getPlayer().getX() && y == game.getPlayer().getY() + 1) {
						valid = false;
					}
				} 
			}
			//eau
			if(game.getPlayer().getTenue() != null && event.getEcran().getTiledmodel().getEau()!=null) {
				if(game.getPlayer().getTenue().getName() != "Bénédiction de Susanoo") {
					for(int i = 0; i< event.getEcran().getTiledmodel().getEau().size(); i++ ) {
						int x = event.getEcran().getTiledmodel().getEau().get(i).Getx();
						int y = event.getEcran().getTiledmodel().getEau().get(i).Gety();
						if (x == game.getPlayer().getX() && y == game.getPlayer().getY()+1) {
							valid = false;
						}
					}
				}
			}
			else if (game.getPlayer().getTenue() == null && event.getEcran().getTiledmodel().getEau()!=null) {
				for(int i = 0; i< event.getEcran().getTiledmodel().getEau().size(); i++ ) {
					int x = event.getEcran().getTiledmodel().getEau().get(i).Getx();
					int y = event.getEcran().getTiledmodel().getEau().get(i).Gety();
					if (x == game.getPlayer().getX() && y == game.getPlayer().getY()+1) {
						valid = false;
					}
				}
			}
			if (event.getEcran().getTiledmodel().getMonstres()!=null) {
				//présence de monstre
				for (int i = 0; i < event.getEcran().getTiledmodel().getMonstres().size(); i++) {
					int x = event.getEcran().getTiledmodel().getMonstres().get(i).getX();
					int y = event.getEcran().getTiledmodel().getMonstres().get(i).getY();
					if (x == game.getPlayer().getX() && y == game.getPlayer().getY() + 1) {
						valid = false;
					}
				} 
			}
			if (event.getEcran().getTiledmodel().getEhumans()!=null) {
				//présence d'ennemis humains
				for (int i = 0; i < event.getEcran().getTiledmodel().getEhumans().size(); i++) {
					int x = event.getEcran().getTiledmodel().getEhumans().get(i).getX();
					int y = event.getEcran().getTiledmodel().getEhumans().get(i).getY();
					if (x == game.getPlayer().getX() && y == game.getPlayer().getY() + 1) {
						valid = false;
					}
				} 
			}
			//validation du mouvement
			if(game.getPlayer().getY()+1 < event.getEcran().getTiledmodel().getHeight() && valid) {
				game.getPlayer().move(game.getPlayer().getX(),game.getPlayer().getY()+1);
			}
			//son de collision
			if(!valid) {
				Sound sound=Gdx.audio.newSound(Gdx.files.internal("Son/bump.mp3"));
				sound.play();
			}
		}	
	}
}
