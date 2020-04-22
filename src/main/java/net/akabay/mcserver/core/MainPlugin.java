package net.akabay.mcserver.core;

import net.akabay.mcserver.commands.*;
import net.akabay.mcserver.listeners.ClickInvShop;
import net.akabay.mcserver.commands.ArmorSee;
import net.akabay.mcserver.commands.EnderChestSee;
import net.akabay.mcserver.commands.GamemodeCommand;
import net.akabay.mcserver.commands.InvSee;
import net.akabay.mcserver.listeners.DeathInventoryListener;
import net.akabay.mcserver.listeners.JoinLeaveListener;
import net.akabay.mcserver.listeners.PassNight;
import net.akabay.mcserver.reward.AchievementsReward;
import net.akabay.mcserver.reward.FirstJoinReward;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class MainPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin successfully enabled");

        this.getCommand("invsee").setExecutor(new InvSee());
        this.getCommand("armorsee").setExecutor(new ArmorSee());
        this.getCommand("enderchestsee").setExecutor(new EnderChestSee());
        this.getCommand("gm").setExecutor(new GamemodeCommand());
        this.getCommand("shop").setExecutor(new Shop());
        register(
                new JoinLeaveListener(),
                new FirstJoinReward(),
                new AchievementsReward(),
                new PassNight(),
                new ClickInvShop(),
                new DeathInventoryListener());
    }

    private void register(Listener... listeners) {
        PluginManager manager = getServer().getPluginManager();
        for(Listener listener : listeners) {
            manager.registerEvents(listener, this);
        }
    }
}
