package de.pattyxdhd.feed;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SlowchatCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("slowchat.use")){

            if(args.length == 0){

                if(SlowChatListener.isSlowed()){
                    SlowChatListener.setSlowed(false);
                    sender.sendMessage(FeedPlugin.getPrefix() + "Du hast den Chat auf Normal gestellt.");
                }else{
                    SlowChatListener.setSlowed(true);
                    sender.sendMessage(FeedPlugin.getPrefix() + "Du hast den Chat auf Slow gestellt.");
                }

            }else{
                sender.sendMessage(FeedPlugin.getPrefix() + "Usage: /slowchat");
            }

        }else{
            sender.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugriff.");
        }

        return false;
    }


}
