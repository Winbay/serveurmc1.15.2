package net.akabay.mcserver.reward;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

public interface StandardGameReward extends GameReward<PlayerEvent> {

    @Override
    default Player getFromEvent(PlayerEvent event) {
        return event.getPlayer();
    }
}
