package de.pattyxdhd.feed;

import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @Getter
    private static CooldownManager mutep = new CooldownManager();

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event){

        if(!getMutep().isDone(event.getPlayer())){
            event.setCancelled(true);
            event.getPlayer().sendMessage(FeedPlugin.getPrefix() + "Du bist noch stumm für §a" + FeedPlugin.convertSekToMin(getMutep().getReminding(event.getPlayer())) + "§7.");
        }

    }


}
