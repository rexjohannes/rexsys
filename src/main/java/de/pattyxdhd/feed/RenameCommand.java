package de.pattyxdhd.feed;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(commandSender instanceof Player){
            Player p = ((Player) commandSender);
            if(p.hasPermission("system.rename")){
                if(args.length >= 1){
                    ItemStack item = p.getItemInHand();
                    if(item.getType() != Material.AIR) {
                        StringBuilder sb = new StringBuilder();

                        int i = 0;
                        while (i < args.length) {
                            if(i<1){
                                sb.append(String.valueOf(args[i]));
                            }else{
                                sb.append(" " + String.valueOf(args[i]));
                            }
                            ++i;
                        }

                        String message = sb.toString();
                        message = message.replaceAll("&", "§");

                        ItemMeta im = item.getItemMeta();
                        im.setDisplayName(message);
                        item.setItemMeta(im);
                        p.setItemInHand(item);
                        p.sendMessage(FeedPlugin.getPrefix() + "Du hast das Item umbenannt: " + message);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                    }else {
                        p.sendMessage(FeedPlugin.getPrefix() + "§cDu hast kein Item in der Hand.");
                    }
                }else{
                    p.sendMessage(FeedPlugin.getPrefix() + "Usage: /rename <Name>");
                }
            }else{
                p.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugriff.");
            }
        }else{
            commandSender.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein.");
        }
        return false;
    }

}
