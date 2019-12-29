package de.pattyxdhd.feed;


import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player){
            Player p = ((Player) sender);
            if(args.length == 0){
                p.sendMessage(FeedPlugin.getPrefix() + "Dein Ping beträgt §a" + getPing(p) + "§7.");
            }else if(args.length == 1){
                if(p.hasPermission("system.ping.other")){
                    Player p2 = Bukkit.getPlayer(args[0]);
                    if(p2 != null){
                        p.sendMessage(FeedPlugin.getPrefix() + "Der Ping von §e" + p2.getName() + " §7beträgt §a" + getPing(p2) + "§7.");
                    }else{
                        p.sendMessage(FeedPlugin.getPrefix() + "§cDer Spieler §e" + args[0] + " §cist nicht Online.");
                        p.playSound(p.getLocation(), Sound.BAT_DEATH, 1, 1);
                    }
                }else{
                    p.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugriff.");
                }
            }else{
                p.sendMessage(FeedPlugin.getPrefix() + "Usage: /ping");
            }
        }else{
            sender.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein!");
        }

        return false;
    }

    private String getPing(Player player){
        return  ((CraftPlayer) player).getHandle().ping + "ms";
    }


}