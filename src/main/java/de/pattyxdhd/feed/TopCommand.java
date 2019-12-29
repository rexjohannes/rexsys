package de.pattyxdhd.feed;

import de.pattyxdhd.feed.FeedPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TopCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("top.use")){

            if(args.length == 0){

                final Location loc = new Location(player.getWorld(), player.getLocation().getX(),
                        player.getWorld().getHighestBlockAt(player.getLocation()).getY(),
                        player.getLocation().getZ(),
                        player.getLocation().getYaw(), player.getLocation().getPitch());

                player.teleport(loc);
                player.sendMessage(FeedPlugin.getPrefix() + "§aDu wurdest zu Höchsten Block an deiner Position teleportiert.");

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Usage: /top");
            }

        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
        }


        return false;
    }


}
