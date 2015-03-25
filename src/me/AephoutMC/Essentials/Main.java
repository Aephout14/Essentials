package me.AephoutMC.Essentials;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin implements Listener
{
  
  public void onEnable()
  { 
    getServer().getPluginManager().registerEvents(this, this);
	saveDefaultConfig();
    getCommand("gmc").setExecutor(new Commands(this));
    getCommand("gms").setExecutor(new Commands(this));
    getCommand("gma").setExecutor(new Commands(this));
    getCommand("gmspec").setExecutor(new Commands(this));
    getCommand("op").setExecutor(new Commands(this));
    getCommand("deop").setExecutor(new Commands(this));
    getCommand("feed").setExecutor(new Commands(this));
    getCommand("heal").setExecutor(new Commands(this));
    getCommand("fly").setExecutor(new Commands(this));
    getCommand("ci").setExecutor(new Commands(this));
    getCommand("workbench").setExecutor(new Commands(this));
    getCommand("echest").setExecutor(new Commands(this));
    getCommand("list").setExecutor(new Commands(this));
    getCommand("sip").setExecutor(new Commands(this));
    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    console.sendMessage("§c§l-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
    console.sendMessage("§c§l+§7§lAephoutMC Essentials Enabled!§c§l+");
    console.sendMessage("§c§l-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
  }
@EventHandler
public void onJoin(PlayerJoinEvent event){
        for (Player player: Bukkit.getServer().getOnlinePlayers()) {

                  event.setJoinMessage(getConfig().getString("onJoinMessage").replace("&", "§").replace("%player%", player.getDisplayName()));
        }
}
        @EventHandler
        public void onQuit(PlayerQuitEvent event){
      	 for(Player player: Bukkit.getServer().getOnlinePlayers()) {
      		 
                   event.setQuitMessage(getConfig().getString("onQuitMessage").replace("&", "§").replace("%player%", player.getDisplayName()));
      	 }
        }
}