package fr.rpgastral.model.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.TimeUtils;

import fr.rpgastral.controler.RpgMain;

/**
 * description des ennemis de type humain
 * on retrouve les brigands, les voleurs, les chefs et les mousses 
 */
public class EnemyHuman extends Enemy{
	
	/**
	 * heure à la nanoseconde près lors du lancement du cooldown
	 */
	private long cooldownstart;
	/**
	 * correspond au taux de pourcentage de chance de convaincre l'ennemi
	 */
	private int taux;

	public EnemyHuman(int x, int y, String n, RpgMain g) {
		super(x, y,n,g);
		this.setPV(3);
		if(this.getName().equals("Mousse")) {
			this.Setdamage(0.5f);
			this.setPortee(1);
			this.setTaux(90);
			this.setTexture(g.getAtlas().findRegion("Game/enemy/mousse"));
			this.setSprite(new Sprite(this.getTexture()));
		}
		else if(this.getName().equals("Brigand")) {
			this.Setdamage(1.25f);
			this.setPortee(1);
			this.setTaux(50);
			this.setTexture(g.getAtlas().findRegion("Game/enemy/brigand"));
			this.setSprite(new Sprite(this.getTexture()));
		}
		else if (this.getName().equals("Voleur")) {
			this.Setdamage(1.25f);
			this.setPosition(1);
			this.setTaux(70);
			this.setPortee(2);
			this.setTexture(g.getAtlas().findRegion("Game/enemy/voleur"));
			this.setSprite(new Sprite(this.getTexture()));
		}
		else if (this.getName().equals("Chef")) {
			this.Setdamage(1.5f);
			this.setPosition(1);
			this.setPortee(2);
			this.setTaux(25);
			this.setPV(5);
			this.setTexture(g.getAtlas().findRegion("Game/enemy/chef"));
			this.setSprite(new Sprite(this.getTexture()));
		}
	}

	/**
	 * gestion de la suppression
	 */
	@Override
	public void dispawn() {
		ArrayList<EnemyHuman> list = this.getG().getTiledModel().getEhumans();
		list.remove(this);
		this.getG().getTiledModel().setEhumans(list);
		if(this.getG().getTiledModel().getEnemys().contains(this)) {
			ArrayList<Enemy> enemys = this.getG().getTiledModel().getEnemys();
			enemys.remove(this);
			this.getG().getTiledModel().setEnemys(enemys);
		}
	}

	/**
	 * gestion de la prise de dégâts 
	 */
	@Override
	public void takedamage(float i) {
		setPV(this.getPV() - i);
        if(!isAlive()) {
        	this.dispawn();
        }
        else if(this.getName().equals("Brigand")) {
        	this.attaque(this.getG().getGamescreen().getPlayer());
        }
	}

	/**
	 * gestion de l'attaque
	 * on se sert de cooldown pour les ennemis attaquant automatiquement le player
	 */
	@Override
	public void attaque(Player p) {
		if(this.getName().equals("Slime")) {
			p.takedamage(this.Getdamage());
		}
		else {
			if(cooldownover()) {
				p.takedamage(this.Getdamage());
				cooldownstart();
			}
		}
	}

	/**
     * lancement du cooldown
     */
    private void cooldownstart() {
    	this.cooldownstart = TimeUtils.nanoTime();
    }
    
    /**
     * on regarde si le cooldown est terminée
     * @return l'état du cooldown false: en cours et true:finit
     */
    private boolean cooldownover() {
    	return (TimeUtils.nanoTime() - this.cooldownstart) >= 2 * 1_000_000_000L;
    }

	public int getTaux() {
		return taux;
	}

	public void setTaux(int taux) {
		this.taux = taux;
	}
}
