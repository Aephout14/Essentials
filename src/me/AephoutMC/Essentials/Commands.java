package me.AephoutMC.Essentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class Commands implements CommandExecutor {
	
  public Commands(Main main) {
	  
  }

  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
  if ((sender instanceof Player))
  {
  	if (cmd.getName().equalsIgnoreCase("gmc"))
      {
        if (args.length == 0)
        {
          sender.sendMessage("§e§lPlease specify a player!");
          return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null)
        {
          sender.sendMessage("§e§lCould not find player " + args[0] + "§e§l!");
          return true;
        }
        target.setGameMode(GameMode.CREATIVE);
        target.sendMessage("§e§lYou are now In Creative Mode!");
      }    	
  }
  if ((sender instanceof Player))
  {
  	if (cmd.getName().equalsIgnoreCase("gms"))
      {
        if (args.length == 0)
        {
          sender.sendMessage("§e§lPlease specify a player!");
          return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null)
        {
          sender.sendMessage("§e§lCould not find player " + args[0] + "§e§l!");
          return true;
        }
        target.setGameMode(GameMode.SURVIVAL);
        target.sendMessage("§e§lYou are now In Survival Mode!");
      }    	
  }
  if ((sender instanceof Player))
  {
  	if (cmd.getName().equalsIgnoreCase("gma"))
      {
        if (args.length == 0)
        {
          sender.sendMessage("§e§lPlease specify a player!");
          return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null)
        {
          sender.sendMessage("§e§lCould not find player " + args[0] + "§e§l!");
          return true;
        }
        target.setGameMode(GameMode.ADVENTURE);
        target.sendMessage("§e§lYou are now In Adventure!");
      }    	
  }
  if ((sender instanceof Player))
  {
  	if (cmd.getName().equalsIgnoreCase("gmspec"))
      {
        if (args.length == 0)
        {
          sender.sendMessage("§e§lPlease specify a player!");
          return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null)
        {
          sender.sendMessage("§e§lCould not find player " + args[0] + "§e§l!");
          return true;
        }
        target.setGameMode(GameMode.SPECTATOR);
        target.sendMessage("§e§lYou are now In Spectator!");
      }    	
  }
    if ((sender instanceof Player))
    {
    	Player player = (Player)sender;
    	if (cmd.getName().equalsIgnoreCase("fly"))
    	{
    	    if(player.isFlying())
    	        player.setFlying(false);
    	        else
    	        player.setFlying(true);
    		}
    	}
    if ((sender instanceof Player))
    {
    	if (cmd.getName().equalsIgnoreCase("op"))
        {
          if (args.length == 0)
          {
            sender.sendMessage("§e§lPlease specify a player!");
            return true;
          }
          Player target = Bukkit.getServer().getPlayer(args[0]);
          if (target == null)
          {
            sender.sendMessage("§e§lCould not find player " + args[0] + "§e§l!");
            return true;
          }
          if(target.hasPermission("me.AephoutMCEssentials.op"))
          target.setOp(true);
          Bukkit.getServer().broadcastMessage("§e§lPlayer " + target.getName() + " §e§lhas been OPed by " + sender.getName() + "§e§l!");
          target.sendMessage("§e§lYou are now OP");
        }    	
    }
    if ((sender instanceof Player))
    {
    	if (cmd.getName().equalsIgnoreCase("deop"))
        {
          if (args.length == 0)
          {
            sender.sendMessage("§e§lPlease specify a player!");
            return true;
          }
          Player target = Bukkit.getServer().getPlayer(args[0]);
          if (target == null)
          {
            sender.sendMessage("§e§lCould not find player " + args[0] + "§c§l!");
            return true;
          }
          target.setOp(false);
          target.sendMessage("§e§lYou are no longer OP");
          Bukkit.getServer().broadcastMessage("§e§lPlayer " + target.getName() + " §e§lhas been Deoped by " + sender.getName() + "§e§l!");
        }    	
    }
    if ((sender instanceof Player))
    {
    	Player player = (Player)sender;
    	if (cmd.getName().equalsIgnoreCase("feed"))
        {
          if (args.length == 0)
          {
            sender.sendMessage("§e§lPlease specify a player!");
            return true;
          }
          Player target = Bukkit.getServer().getPlayer(args[0]);
          if (target == null)
          {
            sender.sendMessage("§e§lCould not find player " + args[0] + "§e§l!");
            return true;
          }
          FoodLevelChangeEvent flce = new FoodLevelChangeEvent(player, 30);
          Bukkit.getServer().getPluginManager().callEvent(flce);
          flce.isCancelled();
          

          target.setFoodLevel(target.getFoodLevel() > 20 ? 20 : flce.getFoodLevel());
          target.setSaturation(10.0F);
          target.setExhaustion(0.0F);
          target.sendMessage("§e§lYou have been feed.");
        }
      }
        if ((sender instanceof Player))
        {
          Player player = (Player)sender;
          if (cmd.getName().equalsIgnoreCase("heal"))
          {
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setFireTicks(0);
            player.sendMessage("§b§l[§f§lHeal§b§l] §f§lYou have Successfully Healed Yourself");
          }
        }
        if ((sender instanceof Player))
        {
          Player player = (Player)sender;
          if (cmd.getName().equalsIgnoreCase("ci"))
          {
        	  player.getInventory().clear();
        	  player.getInventory().setArmorContents(null);
        	  player.sendMessage("§b§l[§f§lClear Inventory§b§l] §f§lYou have Successfully Cleared your Inventory & Armor");
          }
        }
        if ((sender instanceof Player))
        {
          Player player = (Player)sender;
          if (cmd.getName().equalsIgnoreCase("workbench"))
          {
          player.openWorkbench(null, true);
        }
     }
        if ((sender instanceof Player))
        {
          Player player = (Player)sender;
          if (cmd.getName().equalsIgnoreCase("echest"))
          {
        	  player.openInventory(player.getEnderChest());
          }
        }
        if ((sender instanceof Player))
        {
		if (cmd.getName().equalsIgnoreCase("list"))
          {
              for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            	  p.sendMessage("§b§lCurrent Player(s) Online:" + p.getPlayerListName());

          }
        }
		if ((sender instanceof Player))
		{
			Player player = (Player)sender;
			if (cmd.getName().equalsIgnoreCase("sip"))
			{
				if (args.length == 0)
		          {
		            sender.sendMessage("§e§lPlease specify a player!");
		            return true;
		          }
		          Player target = Bukkit.getServer().getPlayer(args[0]);
		          if (target == null)
		          {
		            sender.sendMessage("§e§lCould not find player " + args[0] + "§e§l!");
		            return true;
		          }
					String ip = player.getAddress().getHostString();
				 player.sendMessage(player.getName() + " his IP is: " + ip);
		        }
		      }
	
    	return false;
        }
		return false;
  }
}