package de.pattyxdhd.feed;

import com.google.common.collect.Maps;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class MessageCommand implements CommandExecutor {

    @Getter
    private static HashMap<UUID, UUID> replay = Maps.newHashMap();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein.");
            return false;
        }

        final Player player = ((Player) sender);

        if(args.length >= 2){

            final Player target = Bukkit.getPlayer(args[0]);

            if(target != null){

                StringBuilder stringBuilder = new StringBuilder();

                for(int i = 1;i<args.length;i++){
                    stringBuilder.append(args[i]).append(" ");
                }

                player.sendMessage(FeedPlugin.getPrefix() + "§8[§7mir §a-> §e" + target.getName() + "§8] §f" + stringBuilder.toString());
                target.sendMessage(FeedPlugin.getPrefix() + "§8[§e" + player.getName() + " §a-> §7mir§8] §f" + stringBuilder.toString());
                getReplay().put(player.getUniqueId(), target.getUniqueId());
                getReplay().put(target.getUniqueId(), player.getUniqueId());

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "§cDieser Spieler ist nicht online.");
            }
        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "Usage: /msg <Player> <Message>");
        }

        return false;
    }


}
