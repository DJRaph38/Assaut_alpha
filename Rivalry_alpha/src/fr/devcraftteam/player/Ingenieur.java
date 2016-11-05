package fr.devcraftteam.player;

import org.bukkit.entity.Player;

public class Ingenieur{

	private int lvlIngenieur;
	private float mana;
	private float faim;
	private float life;
	private Player pl;
	
	public Ingenieur(Player p){
		this.pl = p;
	}
	
	public Player getPlayer(){
		return pl;
	}
	
	public void setPlayer(Player p){
		this.pl = p;
	}
	
	public int getLvlG(){
		return lvlIngenieur;
	}
	
	public void setLvlG(int lvlGuerrier){
		this.lvlIngenieur = lvlGuerrier;
	}

	public float getLife() {
		return life;
	}

	public void setLife(float life) {
		this.life = life;
	}

	public float getFaim() {
		return faim;
	}

	public void setFaim(float faim) {
		this.faim = faim;
	}

	public float getMana() {
		return mana;
	}

	public void setMana(float mana) {
		this.mana = mana;
	}

}
