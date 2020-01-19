package de.pattyxdhd.feed;

import java.util.Random;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;




public class FeuerWerkCommand
        implements CommandExecutor
{
    Random r = new Random();

    public boolean onCommand(CommandSender cs, Command Cmd, String arg2, String[] args) {
        Player p = (Player)cs;
        if (p.hasPermission("sys.feuerwerk")) {

            Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
            FireworkEffect effect = FireworkEffect.builder().flicker(this.r.nextBoolean()).withColor(Color.AQUA).withFade(Color.BLACK).with(FireworkEffect.Type.BURST).trail(this.r.nextBoolean()).build();
            for (int i = 0; i < 4; i++) {
                Firework firework = (Firework)loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
                FireworkMeta fwm = firework.getFireworkMeta();
                fwm.addEffect(effect);
                firework.setFireworkMeta(fwm);
            }



            p.sendMessage(FeedPlugin.getPrefix() + "Du hast ein Feuerwerk Yay :D");
            return false;
        }

        p.sendMessage(FeedPlugin.getPrefix() + "§cDazu hast du keinen Zugiff.");


        return true;
    }
}
