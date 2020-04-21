package net.akabay.mcserver.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.YELLOW + event.getPlayer().getDisplayName() + ChatColor.GREEN + " vient de se connecter.");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        event.setQuitMessage(ChatColor.YELLOW + event.getPlayer().getDisplayName() + ChatColor.RED +" vient de se deconnecter.");
    }
}
