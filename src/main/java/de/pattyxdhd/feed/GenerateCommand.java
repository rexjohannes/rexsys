package de.pattyxdhd.feed;

import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GenerateCommand
        implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final Player p = (Player)sender;

        if (p.hasPermission("sys.generate")) {
            Random rmd = new Random();
            int zufallsZahlZwei = rmd.nextInt(100000);
            int zufallsZahlZwei2 = rmd.nextInt(3000000);
            int Euro1 = rmd.nextInt(100);
            int Euro2 = rmd.nextInt(10);
            final int zusammen = zufallsZahlZwei + zufallsZahlZwei2;
            final int zusammenEuro = Euro1 + Euro2;
            (new Thread()
            {
                public void run() {
                    try {
                        sleep(1000L);
                        p.sendMessage(FeedPlugin.getPrefix() + "Bitte warten.");
                        p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 3.0F, 3.0F);
                        sleep(1000L);
                        p.sendMessage(FeedPlugin.getPrefix() + "Bitte warten..");
                        p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 3.0F, 3.0F);
                        sleep(1000L);
                        p.sendMessage(FeedPlugin.getPrefix() + "Bitte warten...");
                        p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 3.0F, 3.0F);
                        sleep(1000L);
                        p.sendMessage(FeedPlugin.getPrefix() + "Bitte warten....");
                        p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 3.0F, 3.0F);
                        sleep(1000L);
                        p.sendMessage(FeedPlugin.getPrefix() + "Bitte warten.....");
                        p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 3.0F, 3.0F);
                        sleep(1000L);
                        p.sendMessage("");
                        p.sendMessage(FeedPlugin.getPrefix() + "Das Limit liegt heute bei: " + zusammenEuro + "Euro");
                        p.sendMessage(FeedPlugin.getPrefix() + "Das Limit liegt heute bei: " + zusammen + "$");

                        p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 3.0F, 3.0F);

                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
        else {

            p.sendMessage(FeedPlugin.getPrefix() + "ERROR");
        }


        return false;
    }
}
