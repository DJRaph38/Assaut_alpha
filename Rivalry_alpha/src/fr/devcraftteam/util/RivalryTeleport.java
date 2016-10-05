package fr.devcraftteam.util;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class RivalryTeleport {

	public static void tpRandom(Player p) {
		Random r = new Random();
		int x = r.nextInt(1000);
		int y = 128;
		int z = - r.nextInt(1000);
		World world = p.getWorld(); //Monde du joueur
		Location randomloc = new Location(world, x, y, z); //Location
		p.teleport(randomloc);
	}

}
