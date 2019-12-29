package de.pattyxdhd.feed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("kick.use")){

            if(args.length >= 2){
                final Player target = Bukkit.getPlayer(args[0]);

                if(target != null){

                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 1;i<args.length;i++){
                        stringBuilder.append(args[i]).append(" ");
                    }

                    target.kickPlayer(stringBuilder.toString().replace('&', '§'));
                    player.sendMessage(FeedPlugin.getPrefix() + "Du hast den Spieler §e" + target.getName() + " §7erfolgreich gekickt. §8[§7" + stringBuilder.toString().replace('&', '§') + "§8]");

                }else{
                    player.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                }


            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Usage: /kick <Player> <Reason>");
            }

        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugriff.");
        }


        return false;
    }

}