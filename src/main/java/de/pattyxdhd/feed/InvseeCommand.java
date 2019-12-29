package de.pattyxdhd.feed;

import de.pattyxdhd.feed.FeedPlugin;
import de.pattyxdhd.feed.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("invsee.use")){

            if(args.length == 1){

                final Player target = Bukkit.getPlayer(args[0]);

                if(target != null){

                    if(!player.hasPermission("invsee.edit")){
                        InventoryClickListener.getNoClick().add(player.getUniqueId());
                    }

                    player.openInventory(target.getInventory());

                }else{
                    player.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                }

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Usage: /invsee <Player>");
            }

        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugriff.");
        }


        return false;
    }
}
