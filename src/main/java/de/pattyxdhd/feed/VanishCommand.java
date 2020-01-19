package de.pattyxdhd.feed;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class VanishCommand
        implements CommandExecutor
{
    String prefix;
    String usage;
    String permission;
    String adminpermission;
    public static ArrayList<Player> hide = new ArrayList();




    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player)cs;
        if (cs instanceof Player) {
            if (p.hasPermission("sys.vanish")) {
                if (args.length == 0) {
                    if (!hide.contains(p)) {
                        hide.add(p);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.hidePlayer(p);
                        }
                        p.sendMessage(FeedPlugin.getPrefix() + "Du bist nun im Vanish!");
                    } else {

                        hide.remove(p);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(p);
                            all.canSee(p);
                        }
                        p.sendMessage(FeedPlugin.getPrefix() + "Du bist nun Sichtbar!");
                    }

                } else if (args.length == 1) {
                    Player t = Bukkit.getPlayer(args[0]);
                    try {
                        if (!hide.contains(p)) {
                            for (Player all2 : Bukkit.getOnlinePlayers()) {
                                all2.hidePlayer(p);
                            }
                            t.sendMessage(FeedPlugin.getPrefix() + "Du bist nun im Vanish!");
                            p.sendMessage(FeedPlugin.getPrefix() + "Der Spieler " + t.getName() + " Ist nun Vanish!");
                        } else {

                            for (Player all2 : Bukkit.getOnlinePlayers()) {
                                all2.showPlayer(p);
                                all2.canSee(p);
                            }
                            t.sendMessage(FeedPlugin.getPrefix() + "Du bist nun Sichtbar!");
                            p.sendMessage(FeedPlugin.getPrefix() + "Der Spieler " + t.getName() + " Ist nun Sichtbar!");
                        }

                    } catch (Exception e) {
                        p.sendMessage(FeedPlugin.getPrefix() + "Der Spieler ist nicht online...");
                    }
                } else {

                    p.sendMessage(FeedPlugin.getPrefix() + this.usage + " /vanish <Spieler>");
                }
            } else {

                p.sendMessage(FeedPlugin.getPrefix() + "Du hast keine Rechte...");
            }
        } else {

            cs.sendMessage(FeedPlugin.getPrefix() + "Du musst ein Spieler sein....");
        }
        return false;
    }
}
