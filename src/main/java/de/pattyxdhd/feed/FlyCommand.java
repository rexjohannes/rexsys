package de.pattyxdhd.feed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            if(args.length == 1){
                final Player target = Bukkit.getPlayer(args[0]);
                if(target != null){
                    toggleFly(target);
                    sender.sendMessage(FeedPlugin.getPrefix() + "§aDer Flugmodus von §e" + target.getName() + " §aist nun auf §e" + target.getAllowFlight() + "§a.");
                }else{
                    sender.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                }
            }
            sender.sendMessage(FeedPlugin.getPrefix() + "Usage: /fly <Player>");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("fly.use")){

            if(args.length == 0){

                toggleFly(player);

            }else if(args.length == 1){

                if(player.hasPermission("fly.use.other")){

                    final Player target = Bukkit.getPlayer(args[0]);

                    if(target != null){

                        toggleFly(target);
                        player.sendMessage(FeedPlugin.getPrefix() + "§aDer Flugmodus von §e" + target.getName() + " §aist nun auf §e" + target.getAllowFlight() + "§a.");

                    }else{
                        player.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                    }

                }else{
                    player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
                }

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Usage: /fly [Player]");
            }

        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
        }


        return false;
    }

    private void toggleFly(final Player player){

        if(player.getAllowFlight()){
            player.setAllowFlight(false);
            player.sendMessage(FeedPlugin.getPrefix() + "§cDu kannst nun nicht mehr Fliegen.");
        }else{
            player.setAllowFlight(true);
            player.sendMessage(FeedPlugin.getPrefix() + "§aDu kannst nun Fliegen.");
        }

    }

}
