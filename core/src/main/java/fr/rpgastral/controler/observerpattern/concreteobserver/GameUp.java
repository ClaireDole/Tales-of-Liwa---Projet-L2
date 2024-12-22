package fr.rpgastral.controler.observerpattern.concreteobserver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import fr.rpgastral.controler.RpgMain;
import fr.rpgastral.controler.observerpattern.Event;

/**
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
		if(event.compare(new Event(game,"GameScreen", true, "UP"))) {
			Boolean valid = true;
			for(int i = 0; i< game.getTiledModelGame().getObstacles().size(); i++ ) {
				int x = game.getTiledModelGame().getObstacles().get(i).Getx();
				int y = game.getTiledModelGame().getObstacles().get(i).Gety();
				if (x == game.getGamescreen().getPlayer().getX() && y == game.getGamescreen().getPlayer().getY()+1) {
					valid = false;
				}
			}
			if(game.getGamescreen().getPlayer().getTenue() != null) {
				if(game.getGamescreen().getPlayer().getTenue().getName() != "Bénédiction de Susanoo") {
					for(int i = 0; i< game.getTiledModelGame().getEau().size(); i++ ) {
						int x = game.getTiledModelGame().getEau().get(i).Getx();
						int y = game.getTiledModelGame().getEau().get(i).Gety();
						if (x == game.getGamescreen().getPlayer().getX() && y == game.getGamescreen().getPlayer().getY()+1) {
							valid = false;
						}
					}
				}
			}
			else if (game.getGamescreen().getPlayer().getTenue() == null) {
				for(int i = 0; i< game.getTiledModelGame().getEau().size(); i++ ) {
					int x = game.getTiledModelGame().getEau().get(i).Getx();
					int y = game.getTiledModelGame().getEau().get(i).Gety();
					if (x == game.getGamescreen().getPlayer().getX() && y == game.getGamescreen().getPlayer().getY()+1) {
						valid = false;
					}
				}
			}
			for(int i = 0; i< game.getTiledModelGame().getMonstres().size(); i++ ) {
				int x = game.getTiledModelGame().getMonstres().get(i).getX();
				int y = game.getTiledModelGame().getMonstres().get(i).getY();
				if (x == game.getGamescreen().getPlayer().getX() && y == game.getGamescreen().getPlayer().getY()+1) {
					valid = false;
				}
			}
			//présence d'ennemis humains
			for(int i = 0; i< game.getTiledModelGame().getEhumans().size(); i++ ) {
				int x = game.getTiledModelGame().getEhumans().get(i).getX();
				int y = game.getTiledModelGame().getEhumans().get(i).getY();
				if (x == game.getGamescreen().getPlayer().getX() && y == game.getGamescreen().getPlayer().getY()+1) {
					valid = false;
				}
			}
			if(game.getGamescreen().getPlayer().getY()+1 < game.getTiledModelGame().getHeight() && valid) {
				game.getGamescreen().getPlayer().move(game.getGamescreen().getPlayer().getX(),game.getGamescreen().getPlayer().getY()+1);
			}
			if(!valid) {
				Sound sound=Gdx.audio.newSound(Gdx.files.internal("Son/bump.mp3"));
				sound.play();
			}
		}
		
	}

}
