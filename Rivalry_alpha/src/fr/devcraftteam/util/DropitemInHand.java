package fr.devcraftteam.util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import fr.devcraftteam.game.RivalryState;

public class DropitemInHand implements Listener {
	@EventHandler
	public void onDropItem(PlayerDropItemEvent e){
		if(RivalryState.isState(RivalryState.WAIT)){
			e.setCancelled(true);
		}//Si le jeu est en attente (waiting room) alors on annule le drop d'item
	}
}
