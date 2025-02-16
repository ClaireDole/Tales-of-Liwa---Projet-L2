package fr.rpg.model.collectible;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

import fr.rpg.controler.RpgMain;
import fr.rpg.model.carte.TiledModel;
import fr.rpg.model.entity.Player;

/**
 * descriptions des potions qui peuvent correspondre soit à des bonus soit à des malus
 * lorsque le joueur récupère une potion, celle-ci disparait et lance son effet
 * on ne peut pas le savoir avant d'avoir vu l'effet sur le joueur
 */
public class Potion extends Collectible{

	public Potion(int x, int y, float e, String s, RpgMain g) {
		super(x,y,e,s,g);
		setTexture(g.getAtlas().findRegion("Game/collectible/potion"));
		setSprite(new Sprite(this.getTexture()));
	}
	/**
	 * les effets possibles selon les potions
	 * la tenue protection d'Amaterasu protège des effets malus
	 * @param p
	 */
	public void effect(Player p) {
		if (p.getTenue()!=null && p.getTenue().getName().equals("Protection d'Amaterasu") && this.getDamage() < 0) {
			setDamage(0);;
		}
		if(this.getName().equals("PV")) {
			p.SetPV(p.getPV() + this.getDamage());
			if(!p.isAlive()) {
				p.SetPV(0.25f);
			}
		}
		if (this.getName().equals("Mana")) {
			p.setMana(p.getMana() + this.getDamage());
		}
		if (this.getName().equals("Attaque")) {
			p.setBonusAttaque(p.getBonusAttaque() + this.getDamage());
		}
	}

	/**
	 * suppression des potions dans le modèle de la carte
	 * pour plus d'informations @see TiledModel class
	 */
	@Override
	public void dispawn(TiledModel tiledmodel) {
		ArrayList<Potion> list = tiledmodel.getPotions();
		list.remove(this);
		tiledmodel.setPotions(list);
	}

}
