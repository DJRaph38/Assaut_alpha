package fr.devcraftteam.game;

public enum RivalryState {
	
	WAIT(true), GAME(false), FINISH(false);
	/**
	 * WAIT : En attente de joueurs, 16 = chronostart
	 * GAME : Partie en cours
	 * FINISH : Partie finie, restart
	 */
	
	//FIELD
	private boolean canJoin;
	private static RivalryState currentstate;
	
	//Constructeur
	RivalryState(boolean canJoin){
		this.canJoin = canJoin;
	}
	
	
	
	//Accesseur
	public static RivalryState getState(){
		return currentstate;
	}
	
	public boolean canJoin(){
		return canJoin;
	}
	
	
	
	//Mutateur
	public static void setState(RivalryState state){
		RivalryState.currentstate = state;
	}
	
	
	
	//Fonction
	public static boolean isState(RivalryState state){
		return RivalryState.currentstate == state;
	}//Verif du jeu
	
}
