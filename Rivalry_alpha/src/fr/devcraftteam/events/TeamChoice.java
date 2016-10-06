package fr.devcraftteam.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import fr.devcraftteam.rivalry.Main;

public class TeamChoice implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		ItemStack item = new ItemStack(Material.STAINED_CLAY, 1, (short) 3); //BLUE
		ItemStack item2 = new ItemStack(Material.STAINED_CLAY, 1, (short) 2); //RED
		if(e.getCurrentItem().getData() == item.getData()){
			p.closeInventory();
			p.sendMessage(ChatColor.AQUA+"BIENVENUE DANS L'EQUIPE BLEUE !");
		}else if(e.getCurrentItem().getData() == item2.getData()){
			p.closeInventory();
			p.sendMessage(ChatColor.LIGHT_PURPLE+"BIENVENUE DANS L'EQUIPE ROUGE !");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClickBlock(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.LEFT_CLICK_AIR ||
				e.getAction() == Action.LEFT_CLICK_BLOCK ||
				e.getAction() == Action.RIGHT_CLICK_BLOCK ||
				e.getAction() == Action.RIGHT_CLICK_AIR){
			
			ItemStack b = p.getItemInHand().getData().toItemStack(); //on obtient la data de l'objet en main
			ItemStack blueclay = new ItemStack(Material.STAINED_CLAY, 1, (short) 3);
			ItemStack magentaclay = new ItemStack(Material.STAINED_CLAY, 1, (short) 2);
			
			if(b.isSimilar(blueclay)){
				p.sendMessage(ChatColor.AQUA+"BIENVENUE DANS L'EQUIPE BLEUE !");
				p.getInventory().clear();
				Main.getInstance().blueTeam.add(p.getUniqueId());
			}else if(b.isSimilar(magentaclay)){
				p.sendMessage(ChatColor.LIGHT_PURPLE+"BIENVENUE DANS L'EQUIPE ROUGE !");
				p.getInventory().clear();
				Main.getInstance().magentaTeam.add(p.getUniqueId());
			}//TEAM CHOICE
			
		}
	}
	
	
}
