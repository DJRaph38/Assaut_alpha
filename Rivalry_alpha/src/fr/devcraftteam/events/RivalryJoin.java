package fr.devcraftteam.events;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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

				if(Main.getInstance().playerInGame.size() > 40){
					p.kickPlayer(ChatColor.AQUA+"Il n'y as plus de place en jeu !");
				}//Kick le joueur si la partie est pleine
				
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
		if(Main.getInstance().playerInGame.size() < 16){
			for(UUID uuid : Main.getInstance().playerInGame){
				Player pl = Bukkit.getPlayer(uuid);
				pl.sendMessage(ChatColor.RED+"Timer arrêté, il faut minimum 16 joueurs pour jouer !");
			}//Pour tous les joueurs
		}
	}//KICK D'UN JOUEUR
}
