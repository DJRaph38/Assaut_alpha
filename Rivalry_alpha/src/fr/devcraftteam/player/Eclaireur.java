package fr.devcraftteam.player;

public class Eclaireur extends Players{

	private int lvlEclaireur;
	private float mana;
	private float faim;
	private float life;
	
	public Eclaireur(){
		super();
	}
	
	public int getLvlG(){
		return lvlEclaireur;
	}
	
	public void setLvlG(int lvlGuerrier){
		this.lvlEclaireur = lvlGuerrier;
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
