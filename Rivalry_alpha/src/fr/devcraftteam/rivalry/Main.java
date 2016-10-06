package fr.devcraftteam.rivalry;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import fr.devcraftteam.events.EventsManager;
import fr.devcraftteam.game.RivalryState;

public class Main extends JavaPlugin{

	public static Main instance; //Instance du plugin
    public ArrayList<UUID> playerInGame = new ArrayList<>(); //liste des joueurs
    public ArrayList<UUID> magentaTeam = new ArrayList<>(); //TEAM MAGENTA
    public ArrayList<UUID> blueTeam = new ArrayList<>(); //TEAM BLEUE
   
    
    
    /**
     * On Enable
     */
    public void onEnable(){    	
    	getLogger().info("on");
        instance = this;
        EventsManager.registerEvents(this); //Events
        RivalryState.setState(RivalryState.WAIT);//Jeu en mode attente
    }
    
    /**
     * On Disable
     */
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
