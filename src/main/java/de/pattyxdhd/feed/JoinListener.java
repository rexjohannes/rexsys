package de.pattyxdhd.feed;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event){
        event.setJoinMessage(" §a+ §8[§e" + event.getPlayer().getName() + "§8]");
    }

    @EventHandler
    public void onQuit(final PlayerQuitEvent event){
        event.setQuitMessage(null);
    }


    @EventHandler
    public void onSecret(AsyncPlayerChatEvent e){
        if(e.getMessage().equalsIgnoreCase("#rex")){
            e.setCancelled(true);
            e.getPlayer().sendMessage("");
            e.getPlayer().sendMessage(FeedPlugin.getPrefix() + "§dSystem §dby rexjohannes98");
            e.getPlayer().sendMessage(FeedPlugin.getPrefix() + " §8» §bdiscord.gg/gCPFbBM");
            e.getPlayer().sendMessage("");
        }

    }

}
