package de.pattyxdhd.feed;

import de.pattyxdhd.feed.FeedPlugin;
import de.pattyxdhd.feed.MuteChatListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MuteChatCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("mutechat.use")){

            if(args.length == 0){

                if(MuteChatListener.isMuted()){
                    MuteChatListener.setMuted(false);
                    sender.sendMessage(FeedPlugin.getPrefix() + "Du hast den Chat entmuted.");
                }else{
                    MuteChatListener.setMuted(true);
                    sender.sendMessage(FeedPlugin.getPrefix() + "Du hast den Chat gemuted.");
                }

            }else{
                sender.sendMessage(FeedPlugin.getPrefix() + "Usage: /mutechat");
            }

        }else{
            sender.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugriff.");
        }

        return false;
    }


}