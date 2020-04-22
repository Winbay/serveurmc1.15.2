package net.akabay.mcserver.reward;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

public interface StandardGameReward<T extends PlayerEvent> extends GameReward<T> {

    @Override
    default Player getFromEvent(T event) {
        return event.getPlayer();
    }
}
