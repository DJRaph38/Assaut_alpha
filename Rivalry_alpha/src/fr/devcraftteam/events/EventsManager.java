package fr.devcraftteam.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.devcraftteam.rivalry.Main;

public class EventsManager {

	public static void registerEvents(Main pl) {
        PluginManager pm = Bukkit.getPluginManager();//register these events
        //EVENTS
        pm.registerEvents(new RivalryJoin(), pl); //Lorsqu'un joueur rejoins le serveur
        pm.registerEvents(new RivalryNoFall(), pl); //Lors du tp en début de jeu
    }//RegisterEvents

}
