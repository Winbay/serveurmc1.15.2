package net.akabay.mcserver.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EnderChestSee implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0 || !(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        for (Player newPlayer : Bukkit.getOnlinePlayers()) {
            if (args[0].equals(newPlayer.getDisplayName())) {
                Inventory inventory = newPlayer.getEnderChest();
                player.openInventory(inventory);
                return true;
            }
        }
        
        return false;
    }
}
