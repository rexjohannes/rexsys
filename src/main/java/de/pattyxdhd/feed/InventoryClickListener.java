package de.pattyxdhd.feed;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.List;
import java.util.UUID;

public class InventoryClickListener implements Listener {

    @Getter
    private static List<UUID> noClick = Lists.newArrayList();

    @EventHandler
    public void onClick(final InventoryClickEvent event){

        if(getNoClick().contains(event.getWhoClicked().getUniqueId())){
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onClose(final InventoryCloseEvent event){

        if(getNoClick().contains(event.getPlayer().getUniqueId()))
            getNoClick().remove(event.getPlayer().getUniqueId());

    }

}
