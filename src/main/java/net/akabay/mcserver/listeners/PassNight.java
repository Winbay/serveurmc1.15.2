package net.akabay.mcserver.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.util.Collection;

public class PassNight implements Listener {

    int nWantsToSleep = 0;

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event){
        if(!event.isCancelled()) {
            nWantsToSleep++;
            passNight(event);
            event.getPlayer().getServer().broadcastMessage(ChatColor.AQUA +"[Bed] " + event.getPlayer().getDisplayName() +
                    " souhaite dormir. " +nWantsToSleep+ " / " +
                    event.getPlayer().getWorld().getPlayers().size()/2);
        }
    }

    @EventHandler
    public void onPlayerBedLeaveEvent(PlayerBedLeaveEvent event){
        nWantsToSleep--;
        event.getPlayer().getServer().broadcastMessage(ChatColor.DARK_AQUA +"[Bed] " +event.getPlayer().getDisplayName() +
                " s'est reveille. " +nWantsToSleep+ " / " +
                event.getPlayer().getWorld().getPlayers().size()/2);
    }

    public void passNight(PlayerBedEnterEvent event){
        World world = event.getPlayer().getWorld();
        int nOnlinePlayers = world.getPlayers().size();
        if(nOnlinePlayers/2 <= nWantsToSleep){
            world.setTime(1000);
        }
    }
}
