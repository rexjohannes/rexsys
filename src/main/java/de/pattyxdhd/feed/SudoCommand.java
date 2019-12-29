package de.pattyxdhd.feed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SudoCommand implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(commandSender instanceof Player){
            Player p = ((Player) commandSender);
            if(p.hasPermission("system.sudo")){
                if(args.length >= 2){
                    Player sudoed = Bukkit.getPlayer(args[0]);
                    if(sudoed != null) {
                        if(!sudoed.hasPermission("system.sudo.bypass")) {
                            String msg = "";
                            for(int i = 1; i < args.length; i++){
                                msg += args[i] + " ";
                            }
                            sudoed.chat(msg);
                            p.sendMessage(FeedPlugin.getPrefix() + "§6" + sudoed.getName() + " §c» §e" + msg);
                        }else {
                            p.sendMessage(FeedPlugin.getPrefix() + "§cDu kannst diesen Spieler nichts ausführen lassen.");
                        }
                    }else {
                        p.sendMessage(FeedPlugin.getPrefix() + "§cDer Spieler §e" + args[0] + " §cist nicht Online.");
                    }
                }else{
                    p.sendMessage(FeedPlugin.getPrefix() + "Usage: /sudo <Spieler> <Nachricht>");
                }
            }else{
                p.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugriff.");
            }
        }else{
            if(args.length >= 2) {
                Player sudoed = Bukkit.getPlayer(args[0]);
                if(sudoed != null) {
                    String msg = "";
                    for(int i = 1; i < args.length; i++){
                        msg += args[i] + " ";
                    }
                    sudoed.chat(msg);
                    commandSender.sendMessage(FeedPlugin.getPrefix() + "§6" + sudoed.getName() + " §c» §e" + msg);
                }else {
                    commandSender.sendMessage(FeedPlugin.getPrefix() + "§cDer Spieler §e" + args[0] + " §cist nicht Online.");
                }
            }else {
                commandSender.sendMessage(FeedPlugin.getPrefix() + "Usage: /sudo <Spieler> <Nachricht>");
            }
        }



        return false;
    }

}
