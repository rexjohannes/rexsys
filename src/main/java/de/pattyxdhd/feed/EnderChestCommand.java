package de.pattyxdhd.feed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class EnderChestCommand
        implements CommandExecutor
{
    public boolean onCommand(CommandSender cs, Command cmd, String args2, String[] args) {
        Player p = (Player)cs;
        if (!p.hasPermission("sys.enderchest")) {
            p.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
        }
        else if (args.length == 1) {
            if (args[0] == null) {
                p.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Spieler ist nicht online.");
            } else {
                p.openInventory(Bukkit.getPlayer(args[0]).getEnderChest());
            }
        }


        return false;
    }
}
