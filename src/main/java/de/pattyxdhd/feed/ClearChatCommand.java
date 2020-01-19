package de.pattyxdhd.feed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand
        implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;

            if (player.hasPermission("system.clearchat")) {
                if (args.length == 0) {
                    for (int i = 0; i <= 125; i++) {
                        Bukkit.broadcastMessage("");
                    }

                    Bukkit.broadcastMessage(FeedPlugin.getPrefix() + "§cder chat wurde gefressen.");
                }
                else if (args.length > 0) {
                    player.sendMessage(FeedPlugin.getPrefix() + "Usage: /clearchat [Zeilen]");
                }
            } else {
                sender.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");
            }
        } else {
            sender.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein.");
        }

        return false;
    }
}
