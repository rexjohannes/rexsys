package de.pattyxdhd.feed;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RexSysCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(FeedPlugin.getPrefix() + "§aby rexjohannes98.");

        return false;
    }
}
