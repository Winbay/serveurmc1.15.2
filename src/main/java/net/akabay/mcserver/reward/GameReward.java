package net.akabay.mcserver.reward;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public interface GameReward<T extends Event> extends Listener {

    ItemStack MONEY = new ItemStack(Material.GOLD_NUGGET, 1);

    Player getFromEvent(T event);
    boolean appliesTo(Player target);
    int getAmount();

    default void grant(T event) {
        Player player = getFromEvent(event);
        if(appliesTo(player)) {
            ItemStack clone = MONEY.clone();
            clone.setAmount(getAmount());
            player.getInventory().addItem(clone);
            player.sendMessage("You have been granted " + getAmount() + " coins!");
        }
    }
}
