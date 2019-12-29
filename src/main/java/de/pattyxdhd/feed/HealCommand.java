package de.pattyxdhd.feed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            if(args.length == 1){
                final Player target = Bukkit.getPlayer(args[0]);
                if(target != null){
                    healOther(target);
                    sender.sendMessage(FeedPlugin.getPrefix() + "§aDu hast den Spieler §e" + target.getName() + "§ageheilt.");
                }else{
                    sender.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                }
                return false;
            }
            sender.sendMessage("Usage: /heal <Player>");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("heal.use")){

            if(args.length == 0){

                healOther(player);

            }else if(args.length == 1){

                if(player.hasPermission("heal.use.other")){

                    final Player target = Bukkit.getPlayer(args[0]);

                    if(target != null){

                        healOther(target);
                        player.sendMessage(FeedPlugin.getPrefix() + "§aDu hast den Spieler §e" + target.getName() + "§ageheilt.");

                    }else{
                        player.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                    }

                }else{
                    player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
                }

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Usage: /heal [Player]");
            }

        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
        }

        return false;
    }

    private void healOther(final Player player){

        player.setFoodLevel(20);
        player.setHealth(20);
        player.setFireTicks(0);
        player.sendMessage(FeedPlugin.getPrefix() + "§aDu wurdest geheilt.");

    }

}
