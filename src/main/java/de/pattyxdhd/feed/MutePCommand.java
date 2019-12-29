package de.pattyxdhd.feed;

import de.pattyxdhd.feed.FeedPlugin;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MutePCommand implements CommandExecutor {

    @Getter
    private static CooldownManager cooldownManager = new CooldownManager();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(player.hasPermission("mutep.use")){

            if(args.length == 1){

                final Player target = Bukkit.getPlayer(args[0]);

                if(target != null){

                    if(getCooldownManager().isDone(player) || player.hasPermission("mutep.bypass")){
                        getCooldownManager().addPlayerToCooldown(player, 1800);

                        ChatListener.getMutep().addPlayerToCooldown(target, 900);

                        target.sendMessage(FeedPlugin.getPrefix() + "Du wurdest von §e" + player.getName() + " §7auf Stumm geschaltet.");
                        target.sendMessage(FeedPlugin.getPrefix() + "Verbleibende Zeit: 15 Minuten");
                        player.sendMessage(FeedPlugin.getPrefix() + "Du hast §e" + target.getName() + " §7für 15 Minuten Stumm geschaltet.");
                    }else{
                        player.sendMessage(FeedPlugin.getPrefix() + "Du musst noch §c" + FeedPlugin.convertSekToMin(getCooldownManager().getReminding(player)) + " §7warten.");
                    }

                }else{
                    player.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
                }

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Usage: /mutep <Player>");
            }

        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugriff.");
        }


        return false;
    }


}
