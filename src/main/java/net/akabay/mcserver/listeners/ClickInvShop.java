package net.akabay.mcserver.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickInvShop implements Listener {

    @EventHandler
    public void onClickInventoryEvent(InventoryClickEvent event){
        if(event.getView().getTitle().equals("Shop")){
            event.setCancelled(true);
        }
    }
}
