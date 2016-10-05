package fr.devcraftteam.rivalry;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import fr.devcraftteam.events.EventsManager;
import fr.devcraftteam.game.RivalryState;

public class Main extends JavaPlugin{

	public static Main instance; //Instance du plugin
    public ArrayList<UUID> playerInGame = new ArrayList<>(); //liste des joueurs
   
    
    
    /**
     * On Enable - Disable
     */
    public void onEnable(){
    	
    	getLogger().info("on");
        instance = this;
        EventsManager.registerEvents(this); //Events
        RivalryState.setState(RivalryState.WAIT);//Jeu en mode attente
        
    }//Plugin s'allume
    
    public void onDisable(){
    	getLogger().info("off");
    }
    
    
    /**
     * Méthodes
     * @return
     */
    public static Main getInstance(){
        return instance;
    }
}
