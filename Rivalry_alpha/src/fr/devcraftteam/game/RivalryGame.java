package fr.devcraftteam.game;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.devcraftteam.rivalry.Main;
import fr.devcraftteam.util.RivalryTeleport;

public class RivalryGame {

	public static void start() {
		// LANCEMENT DU JEU
		RivalryState.setState(RivalryState.GAME);
		
		for(UUID uuid : Main.getInstance().playerInGame){
			Player pl = Bukkit.getPlayer(uuid);
			pl.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 1)); //Boost de vitesse pendant 4s
			
			
			//KITS
			
			
			//TP DES JOUEURS (alea)
			RivalryTeleport.tpRandom(pl);
			
		}//Pour tous les joueurs
	}


}
