package net.akabay.mcserver.core;

import net.akabay.mcserver.commands.ArmorSee;
import net.akabay.mcserver.commands.EnderChestSee;
import net.akabay.mcserver.commands.Gamemode;
import net.akabay.mcserver.commands.InvSee;
import net.akabay.mcserver.listeners.JoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin successfully enabled");

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);

        this.getCommand("invsee").setExecutor(new InvSee());
        this.getCommand("armorsee").setExecutor(new ArmorSee());
        this.getCommand("enderchestsee").setExecutor(new EnderChestSee());
        this.getCommand("gm").setExecutor(new Gamemode());
    }
}
