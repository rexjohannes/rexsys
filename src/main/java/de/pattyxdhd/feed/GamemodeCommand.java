package de.pattyxdhd.feed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("gamemode.use")){

            if(args.length == 1){

                GamemodeManager.changeGamemode(player, args[0]);

            }else if(args.length == 2){

                final Player target = Bukkit.getPlayer(args[1]);

                if(target != null){

                    GamemodeManager.changeGamemode(target, args[0], player);

                }else{
                    player.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                }

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Usage: /gm <0,1,2,3> [Player]");
            }

        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
        }


        return false;
    }
}
