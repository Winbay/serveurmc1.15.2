package net.akabay.mcserver.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Shop implements CommandExecutor {

    private Inventory inventory;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            createInventoryShop(player);
            player.openInventory(inventory);
            return true;
        }
        return false;
    }

    public void createInventoryShop(Player player){
        inventory = Bukkit.createInventory(player, 9,"Shop");
        ItemStack elytra = new ItemStack(Material.ELYTRA, 1);
        ItemMeta elytraMeta = elytra.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.RED + "Test");
        elytraMeta.setLore(lore);
        elytra.setItemMeta(elytraMeta);
        inventory.setItem(0, elytra);
    }
}
