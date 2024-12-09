package fr.rpgastral.controler.observerpattern.concreteobserver;

import fr.rpgastral.controler.RpgMain;
import fr.rpgastral.controler.observerpattern.Event;

public class GameUp extends concreteobserver{
	
	public GameUp(String name) {
		super(name);
	}

	@Override
	public void update(Event event) {
		RpgMain game = event.getGame();
		if(event.compare(new Event(game,"GameScreen", true, "UP"))) {
			Boolean valid = true;
			for(int i = 0; i< game.getTiledModel().getObstacles().size(); i++ ) {
				int x = game.getTiledModel().getObstacles().get(i).Getx();
				int y = game.getTiledModel().getObstacles().get(i).Gety();
				if (x == game.getGamescreen().getPlayer().Getx() && y == game.getGamescreen().getPlayer().Gety()+1) {
					valid = false;
				}
			}
			if(game.getGamescreen().getPlayer().getTenue() != null) {
				if(game.getGamescreen().getPlayer().getTenue().Getname() != "Bénédiction de Susanoo") {
					for(int i = 0; i< game.getTiledModel().getEau().size(); i++ ) {
						int x = game.getTiledModel().getEau().get(i).Getx();
						int y = game.getTiledModel().getEau().get(i).Gety();
						if (x == game.getGamescreen().getPlayer().Getx() && y == game.getGamescreen().getPlayer().Gety()+1) {
							valid = false;
						}
					}
				}
			}
			else if (game.getGamescreen().getPlayer().getTenue() == null) {
				for(int i = 0; i< game.getTiledModel().getEau().size(); i++ ) {
					int x = game.getTiledModel().getEau().get(i).Getx();
					int y = game.getTiledModel().getEau().get(i).Gety();
					if (x == game.getGamescreen().getPlayer().Getx() && y == game.getGamescreen().getPlayer().Gety()+1) {
						valid = false;
					}
				}
			}
			if(game.getGamescreen().getPlayer().Gety()+1 < game.getTiledModel().getHeight() && valid) {
				game.getGamescreen().getPlayer().move(game.getGamescreen().getPlayer().Getx(),game.getGamescreen().getPlayer().Gety()+1);
			}
		}
		
	}

}
