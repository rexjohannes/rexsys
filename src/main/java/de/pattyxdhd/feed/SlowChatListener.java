package de.pattyxdhd.feed;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SlowChatListener implements Listener {

    @Getter @Setter
    private static boolean slowed = false;

    @Getter
    private final CooldownManager cooldownManager = new CooldownManager();

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event){

        if(isSlowed() && !event.getPlayer().hasPermission("slochat.bypass")){

            if(!getCooldownManager().isDone(event.getPlayer())){
                event.setCancelled(true);
                event.getPlayer().sendMessage(FeedPlugin.getPrefix() + "Du kannst nur alle 3 Sekunden schreiben.");
            }else{
                getCooldownManager().addPlayerToCooldown(event.getPlayer(), 3);
            }

        }

    }


}
