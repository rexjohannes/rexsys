package de.pattyxdhd.feed;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RTPCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("rtp.use")){

            if(args.length == 0){

                if(player.getWorld().getName().equals("world")){

                    RTPManager.rtp(player);

                }else{
                    player.sendMessage(FeedPlugin.getPrefix() + "§cDu musst in der Farmwelt sein.");
                }

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Usage: /rtp");
            }

        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugriff.");
        }

        return false;
    }
}
