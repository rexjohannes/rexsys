package de.pattyxdhd.feed;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MuteChatListener implements Listener {

    @Getter @Setter
    private static boolean muted = false;

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event){

        if(isMuted() && !event.getPlayer().hasPermission("mutechat.bypass")){
            event.setCancelled(true);
            event.getPlayer().sendMessage(FeedPlugin.getPrefix() + "§cDer Chat ist zuzeit deaktiviert.");
        }

    }

}