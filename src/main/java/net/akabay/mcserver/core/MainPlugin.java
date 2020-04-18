package net.akabay.mcserver.core;

import net.akabay.mcserver.listeners.JoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin successfully enabled");

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
    }
}
