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
            GameMode gm = findGameMode(args[0]);
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

    public GameMode findGameMode(String arg){
        switch (arg){
            case "0":
                return GameMode.SURVIVAL;
            case "1":
                return GameMode.CREATIVE;
            case "2":
                return GameMode.ADVENTURE;
            default:
                return GameMode.SPECTATOR;
        }
    }
}
