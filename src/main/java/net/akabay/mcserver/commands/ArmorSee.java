package net.akabay.mcserver.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ArmorSee implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0 && sender instanceof Player) {
            Player player = (Player) sender;
            for (Player newPlayer : Bukkit.getOnlinePlayers()) {
                if (args[0].equals(newPlayer.getDisplayName())) {
                    ItemStack[] armoList = newPlayer.getInventory().getArmorContents();
                    Inventory newInventory = Bukkit.createInventory(player, 9);
                    for(ItemStack item : armoList){
                        newInventory.addItem(item);
                    }
                    player.openInventory(newInventory);
                    return true;
                }
            }
        }
        return false;

    }
}
