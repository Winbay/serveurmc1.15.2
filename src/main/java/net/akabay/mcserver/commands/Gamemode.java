package net.akabay.mcserver.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int n = args.length;
        if (n > 0 && sender instanceof Player) {
            Player player = (Player) sender;
            GameMode gm;
            switch (args[0]){
                case "0":
                    gm = GameMode.SURVIVAL;
                    break;
                case "1":
                    gm = GameMode.CREATIVE;
                    break;
                case "2":
                    gm = GameMode.ADVENTURE;
                    break;
                case "3":
                    gm = GameMode.SPECTATOR;
                    break;
                default:
                    return false;
            }
            if (n == 1) {
                player.setGameMode(gm);
                return true;
            }
            for (Player newPlayer : Bukkit.getOnlinePlayers()) {
                if (args[1].equals(newPlayer.getDisplayName())) {
                        newPlayer.setGameMode(gm);
                        return true;
                }
            }
        }
        return false;
    }
}
