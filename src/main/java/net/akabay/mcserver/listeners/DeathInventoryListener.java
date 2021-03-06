package net.akabay.mcserver.listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.stream.Collectors;

public class DeathInventoryListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        Player player = event.getEntity();
        World world = player.getWorld();
        GameRule<Boolean> keepInventory = GameRule.KEEP_INVENTORY;

        boolean initialInventoryRule = Optional.ofNullable(world.getGameRuleValue(keepInventory)).orElse(false);
        world.setGameRule(keepInventory, true);

        organizeItems(player);

        world.setGameRule(keepInventory, initialInventoryRule);
    }

    private void organizeItems(Player player) {

        Queue<ItemStack> contents = getContentsAsQueue(player);
        Location deathLoc = player.getLocation();

        while(!storeContents(contents, deathLoc.add(0, 1, 0))) { }

        player.getInventory().clear();
        provideDeathLocation(player, deathLoc);
    }

    private void provideDeathLocation(Player player, Location loc) {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        String message = String.format("Death coordinates : (%.0f, %.0f, %.0f)", loc.getX(), loc.getY(), loc.getZ());
        meta.setDisplayName(message);
        item.setItemMeta(meta);
        player.getInventory().addItem(item);
    }

    /**
     * @param contents the contents to fit in chests
     * @param location where the current chest should be placed
     * @return whether the queue has been emptied or not
     */
    private boolean storeContents(Queue<ItemStack> contents, Location location) {

        if(contents.size() == 0) return true; // In case the player dies with an empty inventory, so that we avoid generating an empty chest

        Block block = location.getBlock();
        if(block.getType() != Material.AIR && location.getY() < 255) {
            // We don't want to fall here if we're too close to the height limit, going any higher might cause errors
            return false;
        }

        block.setType(Material.CHEST);
        Chest newBlock = (Chest) location.getBlock().getState();
        Inventory blockInventory = newBlock.getBlockInventory();
        for(int i = 0; i < blockInventory.getSize(); i++) {
            ItemStack current = contents.poll();
            blockInventory.setItem(i, current);
            if(contents.size() == 0) return true;
        }

        return false;
    }

    private Queue<ItemStack> getContentsAsQueue(Player player) {
        PlayerInventory inv = player.getInventory();
        Queue<ItemStack> list = new LinkedList<>();
        list.addAll(Arrays.asList(inv.getArmorContents()));
        list.addAll(Arrays.asList(inv.getExtraContents()));
        list.addAll(Arrays.asList(inv.getStorageContents()));
        return list
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
