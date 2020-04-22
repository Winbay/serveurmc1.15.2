package net.akabay.mcserver.listeners;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PassNight implements Listener {

    private int nWantsToSleep = 0;

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event){
        if(!event.isCancelled()) {
            nWantsToSleep++;
            Player player = event.getPlayer();
            player.getServer().broadcastMessage(ChatColor.AQUA +"[Bed] " + player.getDisplayName() +
                    " souhaite dormir. " +nWantsToSleep+ " / " +
                    player.getWorld().getPlayers().size()/2);
            passNight(event);
        }
    }

    @EventHandler
    public void onPlayerBedLeaveEvent(PlayerBedLeaveEvent event){
        nWantsToSleep--;
        Player player = event.getPlayer();
        player.getServer().broadcastMessage(ChatColor.DARK_AQUA +"[Bed] " + player.getDisplayName() +
                " s'est reveille. " +nWantsToSleep+ " / " +
                player.getWorld().getPlayers().size()/2);
    }

    private void passNight(PlayerBedEnterEvent event){
        World world = event.getPlayer().getWorld();
        int nOnlinePlayers = world.getPlayers().size();
        if(nOnlinePlayers/2 <= nWantsToSleep){
            world.setTime(1000);
        }
    }
}
