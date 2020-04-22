package net.akabay.mcserver.reward;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AchievementsReward implements StandardGameReward<PlayerAdvancementDoneEvent> {

    private Map<String, Integer> rewards;

    public AchievementsReward() {
        this.rewards = new HashMap<>();
        fill();
    }

    private void fill() {
        this.put("end/the_end", 20)
                .put("end/free_the_end", 40)
                .put("end/the_next_generation", 5)
                .put("end/remote_getaway", 10)
                .put("end/the_end...again...", 20)
                .put("end/you_need_a_mint", 10)
                .put("the_city_at_the_end_of_the_game", 15)
                .put("sky's_the_limit", 5)
                .put("great_view_from_up_here", 10);
    }

    private AchievementsReward put(String key, Integer val) {
        rewards.put(key, val);
        return this;
    }

    @EventHandler
    public void onAchievementGranted(PlayerAdvancementDoneEvent event) {
        grant(event);
    }

    @Override
    public boolean appliesTo(Player target) {
        return true;
    }

    @Override
    public int getAmount(PlayerAdvancementDoneEvent event) {
        NamespacedKey key = event.getAdvancement().getKey();
        String strKey = key.getKey();
        System.out.println("Player got the following achievement key : " + strKey);
        return Optional.ofNullable(rewards.get(strKey)).orElse(0);
    }
}
