package net.akabay.mcserver.core;

import net.akabay.mcserver.listeners.JoinLeaveListener;
import net.akabay.mcserver.reward.FirstJoinReward;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class MainPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin successfully enabled");
        register(new JoinLeaveListener(), new FirstJoinReward());
    }

    private void register(Listener... listeners) {
        PluginManager manager = getServer().getPluginManager();
        for(Listener listener : listeners) {
            manager.registerEvents(listener, this);
        }
    }
}
