package net.akabay.mcserver.reward;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinReward implements StandardGameReward<PlayerJoinEvent> {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        grant(event);
    }

    @Override
    public boolean appliesTo(Player target) {
        return !target.hasPlayedBefore();
    }

    @Override
    public int getAmount(PlayerJoinEvent event) {
        return 20;
    }
}
