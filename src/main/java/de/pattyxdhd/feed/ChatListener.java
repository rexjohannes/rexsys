package de.pattyxdhd.feed;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
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


    @EventHandler
    public void on(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();

        List<String> blocked = new ArrayList<String>();
        blocked.add("arsch ");
        blocked.add("bot");
        blocked.add("ez");

        for (String block : blocked) {
            if (msg.contains(block)) {
                String replace = "";
                for (int i = 0; i < block.length(); i++) {
                    replace = replace + "#";
                }
                String NewMessage = msg.replace(block, replace);
                e.setMessage(NewMessage);
                p.sendMessage(FeedPlugin.getPrefix() + "§aAchte auf deine Wortwahl! §b(" + block + ")");
            }
        }
    }


}
