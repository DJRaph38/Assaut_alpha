/**
 * DAAAAMN, UN PACKAGE ENORME ET SEC
 */

package fr.devcraftteam.events;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.devcraftteam.game.RivalryGame;
import fr.devcraftteam.game.RivalryState;
import fr.devcraftteam.rivalry.Main;

public class RivalryJoin implements Listener {
	//Variables
	static int task;
	static int timer = 120;
	
	@EventHandler
	public void join(PlayerJoinEvent e){
		Player p = e.getPlayer();//Player who want to join the game
		
		if(RivalryState.isState(RivalryState.WAIT)){
			if(!Main.getInstance().playerInGame.contains(p.getUniqueId())){
				Main.getInstance().playerInGame.add(p.getUniqueId()); //Joueur pas dans la liste, add him

				/**
				 * Vérifie si le joueur peut se connecter
				 */
				if(Main.getInstance().playerInGame.size() > 40){
					p.kickPlayer(ChatColor.AQUA+"Il n'y as plus de place en jeu !");
				}else{
					/**
					 * 1 - Clear inventory
					 * 2 - Création des clays bleues et rouges
					 * 3 - Ajout de titres
					 * 4 - Ajout de clay dans l'inventaire
					 */
					p.getInventory().clear(); //1
					ItemStack blueclay = new ItemStack(Material.STAINED_CLAY, 1, (short) 3); //2
					ItemStack magentaclay = new ItemStack(Material.STAINED_CLAY, 1, (short) 2);
					
					ItemMeta itemMeta1 = blueclay.getItemMeta();
					ItemMeta itemMeta2 = magentaclay.getItemMeta();
					itemMeta1.setDisplayName(ChatColor.DARK_RED+"Equipe Rouge");
					itemMeta2.setDisplayName(ChatColor.DARK_BLUE+"Equipe Bleue");
					ArrayList<String> lore1 = new ArrayList<String>();
					ArrayList<String> lore2 = new ArrayList<String>();
					lore1.add(ChatColor.LIGHT_PURPLE+"> Clique pour rejoindre l'équipe rouge !");
					lore2.add(ChatColor.AQUA+"> Clique pour rejoindre l'équipe bleue !");
					itemMeta1.setLore(lore1);
					itemMeta2.setLore(lore2);
					blueclay.setItemMeta(itemMeta2);
					magentaclay.setItemMeta(itemMeta1);//3
					
					p.getInventory().addItem(blueclay); //4
					p.getInventory().addItem(magentaclay);
				}
				
				/**
				 * Vérifie si le timer peut se lancer
				 */
				if(Main.getInstance().playerInGame.size() >= 1){
					//Chrono start if player == 1
					task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable(){
						
						@Override
						public void run() {
							timer--;
							setLevel(timer);
							
							if(timer == 30 || timer == 60 || timer == 120){
								for(UUID uuid : Main.getInstance().playerInGame){
									Player pl = Bukkit.getPlayer(uuid);
									pl.sendMessage(ChatColor.GOLD+"Le jeu commence dans "+timer+" secondes");
								}
							}// 30s, 60s, 120s
							
							if(timer <= 10){
								for(UUID uuid : Main.getInstance().playerInGame){
									Player pl = Bukkit.getPlayer(uuid);
									pl.sendMessage(ChatColor.GOLD+"Le jeu commence dans "+timer+" secondes");
								}						
							}// Repeat every seconds
							
							if(timer == 0){
								Bukkit.getScheduler().cancelTask(task);
								
								// LANCEMENT DU JEU -------------------
								p.getInventory().clear();
								RivalryGame.start();
								//-------------------------------------
								
							}//stop & tp players
						}
					},20,20);
				}	
			}
		}else{
			p.kickPlayer(ChatColor.GOLD+"Jeu actuellement en cours, impossible de rejoindre !");
		}
	}
	
	
	
	
	public void setLevel(int timer){
		for(UUID uuid : Main.getInstance().playerInGame){
			Player pl = Bukkit.getPlayer(uuid);
			pl.setLevel(timer);
		}//Pour tous les joueurs	
	}//XP = TIMER (petit effet de style)
	
	
	
	
	@EventHandler
	public void quit(PlayerQuitEvent e){
		Player p = e.getPlayer(); //Player who left the game
		Main.getInstance().playerInGame.remove(p.getUniqueId());//Not in PlayerInGame list
		
		// ON ENLEVE LE JOUEUR DE SON EVENTUELLE EQUIPE
		if(Main.getInstance().blueTeam.contains(p.getUniqueId())){
			Main.getInstance().blueTeam.remove(p.getUniqueId());
		}else if(Main.getInstance().magentaTeam.contains(p.getUniqueId())){
			Main.getInstance().magentaTeam.remove(p.getUniqueId());
		}
		
		if(Main.getInstance().playerInGame.size() < 16){
			for(UUID uuid : Main.getInstance().playerInGame){
				Player pl = Bukkit.getPlayer(uuid);
				pl.sendMessage(ChatColor.RED+"Timer arrêté, il faut minimum 16 joueurs pour jouer !");
			}//Pour tous les joueurs
		}
	}//DEPART D'UN JOUEUR
	
	
	
	
	@EventHandler
	public void quit(PlayerKickEvent e){
		Player p = e.getPlayer(); //Player who left the game
		Main.getInstance().playerInGame.remove(p.getUniqueId());//Not in PlayerInGame list
		
		// ON ENLEVE LE JOUEUR DE SON EVENTUELLE EQUIPE
		if(Main.getInstance().blueTeam.contains(p.getUniqueId())){
			Main.getInstance().blueTeam.remove(p.getUniqueId());
		}else if(Main.getInstance().magentaTeam.contains(p.getUniqueId())){
			Main.getInstance().magentaTeam.remove(p.getUniqueId());
		}
		
		// ON ENLEVE LE JOUEUR DES JOUEURS EN JEU
		if(Main.getInstance().playerInGame.size() < 16){
			for(UUID uuid : Main.getInstance().playerInGame){
				Player pl = Bukkit.getPlayer(uuid);
				pl.sendMessage(ChatColor.RED+"Timer arrêté, il faut minimum 16 joueurs pour jouer !");
			}//Pour tous les joueurs
		}
	}//KICK D'UN JOUEUR
}
