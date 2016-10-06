package fr.devcraftteam.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.devcraftteam.rivalry.Main;
import fr.devcraftteam.util.DropitemInHand;
import fr.devcraftteam.util.RivalrySpeedRecipes;

public class EventsManager {

	public static void registerEvents(Main pl) {
        PluginManager pm = Bukkit.getPluginManager();//register these events
        //EVENTS
        /**
         * DEBUT DU JEU - WAITING ROOM
         */
        pm.registerEvents(new RivalryJoin(), pl); //Lorsqu'un joueur rejoins le serveur
        pm.registerEvents(new DropitemInHand(), pl);//Lorsqu'un joueur drop un item (juste pour la waiting room)
        
        /**
         * DEBUT DU JEU - TP
         */
        pm.registerEvents(new RivalryNoFall(), pl); //Lors du tp en début de jeu
        
        /**
         * JEU - GAMERULES
         */
        pm.registerEvents(new RivalrySpeedRecipes(), pl); //DELETE
    }//RegisterEvents

}
