package fr.devcraftteam.player;

public class Guerrier extends Players{
	
	private int lvlGuerrier;
	private float mana;
	private float faim;
	private float life;
	
	public Guerrier(){
		super();
	}
	
	public int getLvlG(){
		return lvlGuerrier;
	}
	
	public void setLvlG(int lvlGuerrier){
		this.lvlGuerrier = lvlGuerrier;
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
