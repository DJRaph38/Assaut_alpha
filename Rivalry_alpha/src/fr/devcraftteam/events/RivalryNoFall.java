package fr.devcraftteam.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class RivalryNoFall implements Listener {

	@EventHandler
	public void damagebyFall(EntityDamageEvent e){
		if(e.getCause() == DamageCause.FALL){
			e.setCancelled(true);
		}//Chute du joueur
	}
}
