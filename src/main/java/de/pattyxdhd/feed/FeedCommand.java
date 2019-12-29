package de.pattyxdhd.feed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            if(args.length == 1){
                final Player target = Bukkit.getPlayer(args[0]);
                if(target != null){
                    target.setFoodLevel(20);
                    target.sendMessage(FeedPlugin.getPrefix() + "§aDein Hunger wurde gestillt.");
                    sender.sendMessage(FeedPlugin.getPrefix() + "§aDu hast den Hunger von §e" + target.getName() + " §agestillt.");
                }else{
                    sender.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                }
                return false;
            }
            sender.sendMessage(FeedPlugin.getPrefix() + "Usage: /feed <Player>");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("feed.use")){

            if(args.length == 0){

                player.setFoodLevel(20);
                player.sendMessage(FeedPlugin.getPrefix() + "§aDein Hunger wurde gestillt.");

            }else if(args.length == 1){

                if(player.hasPermission("feed.use.other")){

                    final Player target = Bukkit.getPlayer(args[0]);

                    if(target != null){
                        target.setFoodLevel(20);
                        target.sendMessage(FeedPlugin.getPrefix() + "§aDein Hunger wurde gestillt.");
                        player.sendMessage(FeedPlugin.getPrefix() + "§aDu hast den Hunger von §e" + target.getName() + " §agestillt.");
                    }else{
                        player.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                    }
                }else{
                    player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
                }

            } else{
                player.sendMessage(FeedPlugin.getPrefix() + "Usage: /feed [Player]");
            }

        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
        }


        return false;
    }

}
