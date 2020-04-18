package net.akabay.mcserver.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage("§6" + event.getPlayer().getName() + "§a vient de se connecter.");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        event.setQuitMessage("§6"+ event.getPlayer().getName() +"§c vient de se deconnecter.");
    }
}
