package fr.rpgastral.model;

import java.util.ArrayList;
import fr.rpgastral.model.carte.Terrain;
import fr.rpgastral.model.collectible.Potion;
import fr.rpgastral.model.collectible.Tenue;
import fr.rpgastral.model.entity.PNJ;

public class TiledModel {
	private int width;
	private int height;
	private int tilewidth;
	private int tileheight;
	private ArrayList<Terrain> eau;
	private ArrayList<Terrain> volcanique;
	private ArrayList<Terrain> obstacles;
	private ArrayList<Terrain> chemin;
	private ArrayList<Terrain> plaine;
	private ArrayList<PNJ> pnj;
	private ArrayList<Potion> potion;
	private ArrayList<Tenue> tenue;
	
	
	public ArrayList<Terrain> getEau() {
		return eau;
	}
	public void setEau(ArrayList<Terrain> eau) {
		this.eau = eau;
	}
	public ArrayList<Terrain> getVolcanique() {
		return volcanique;
	}
	public void setVolcanique(ArrayList<Terrain> volcanique) {
		this.volcanique = volcanique;
	}
	public ArrayList<Terrain> getObstacles() {
		return obstacles;
	}
	public void setObstacles(ArrayList<Terrain> obstacles) {
		this.obstacles = obstacles;
	}
	public ArrayList<Terrain> getChemin() {
		return chemin;
	}
	public void setChemin(ArrayList<Terrain> chemin) {
		this.chemin = chemin;
	}
	public ArrayList<Terrain> getPlaine() {
		return plaine;
	}
	public void setPlaine(ArrayList<Terrain> plaine) {
		this.plaine = plaine;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getTilewidth() {
		return tilewidth;
	}
	public void setTilewidth(int tilewidth) {
		this.tilewidth = tilewidth;
	}
	public int getTileheight() {
		return tileheight;
	}
	public void setTileheight(int tileheight) {
		this.tileheight = tileheight;
	}
	public ArrayList<PNJ> getPnj() {
		return pnj;
	}
	public void setPnj(ArrayList<PNJ> pnj) {
		this.pnj = pnj;
	}
	public ArrayList<Potion> getPotion() {
		return potion;
	}
	public void setPotion(ArrayList<Potion> potion) {
		this.potion = potion;
	}
	public ArrayList<Tenue> getTenue() {
		return tenue;
	}
	public void setTenue(ArrayList<Tenue> tenue) {
		this.tenue = tenue;
	}
	
	
}
