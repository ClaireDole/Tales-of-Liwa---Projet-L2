package fr.rpg.model.collectible;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

import fr.rpg.controler.RpgMain;
import fr.rpg.model.carte.TiledModel;

/**
 * description des différentes armes du jeu et de leurs spécificités
 */
public class Armes extends Collectible{
	private Boolean maindouble;
	private int cout;
	private int portee;

	/**
	 * constructeur
	 * @param x abscisse
	 * @param y ordonnée
	 * @param s nom
	 * @param g instance de la classe main
	 */
	public Armes(int x, int y, String s, RpgMain g) {
		super(x,y,s,g);
		this.maindouble = false;
		this.cout = 0;
		if (s =="Bâton") {
			setDamage(1); 
			this.portee = 1;
			setTexture(getG().getAtlas().findRegion("Game/collectible/baton"));
			setDescription("Arme de base, dégâts : 1, portée : 1");
		}
		else if (s=="Epée") {
			setDamage(2);
			this.portee = 1;
			setTexture(getG().getAtlas().findRegion("Game/collectible/epee"));
			setDescription("Une épée de bonne qualitée, dégâts : 2, portée : 1");
		}
		else if (s=="Hâche") {
			setDamage(3);
			this.portee = 1;
			this.maindouble = true;
			setTexture(getG().getAtlas().findRegion("Game/collectible/hache"));
			setDescription("Une lourde hâche qu'ilf aut prendre à deux mains, dégâts : 3, portée : 1");
		}
		else if (s=="Sceptre") {
			setDamage(3);
			this.cout = 1;
			this.portee = 3;
			setTexture(getG().getAtlas().findRegion("Game/collectible/sceptre"));
			setDescription("L'arme d'un puissant mage, dégâts : 3, portée : 3");
		}
		else if (s=="Arc"){
			setDamage(2);
			this.portee = 2;
			setTexture(getG().getAtlas().findRegion("Game/collectible/arc"));
			setDescription("Une arme à distance, dégâts : 2, portée : 2");
		}
		setSprite(new Sprite(this.getTexture()));
	}

	/**
	 * suppression des armes dans le modèle de la carte
	 * pour plus d'informations @see TiledModel class
	 */
	@Override
	public void dispawn(TiledModel tiledmodel) {
		ArrayList<Armes> list = tiledmodel.getArmes();
		list.remove(this);
		tiledmodel.setArmes(list);
	}

	/**
	 * getter
	 * @return si l'arme prend les deux slots de mains du player
	 */
	public Boolean getMaindouble() {
		return maindouble;
	}

	/**
	 * setter
	 * @param maindouble
	 */
	public void setMaindouble(Boolean maindouble) {
		this.maindouble = maindouble;
	}

	/**
	 * getter
	 * @return cout en mana de l'arme
	 */
	public int getCout() {
		return cout;
	}

	/**
	 * setter
	 * @param cout
	 */
	public void setCout(int cout) {
		this.cout = cout;
	}

	/**
	 * getter
	 * @return portée de l'arme
	 */
	public int getPortee() {
		return portee;
	}

	/**
	 * setter
	 * @param portee
	 */
	public void setPortee(int portee) {
		this.portee = portee;
	}

}
