package net.txsla.command;

import org.bukkit.plugin.java.JavaPlugin;
import net.txsla.command.commands.*;

public final class Command extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getLogger().info("Starting plugin...");

        // only register enabled commands
        getLogger().info("loading commands:");

        // clear
        if (getConfig().getBoolean("clear.enabled")) {
            getCommand("clear").setExecutor(new clear());
            getLogger().info("+ clear");
        }else {
            getCommand("clear").setExecutor(new disabled());
        }

        // gamemode
        if (getConfig().getBoolean("gamemode.enabled")) {
            getCommand("gamemode").setExecutor(new gamemode());
            getLogger().info("+ gamemode");
        }else {
            getCommand("gamemode").setExecutor(new disabled());
        }

        // teleport
        if (getConfig().getBoolean("teleport.enabled")) {
            getCommand("teleport").setExecutor(new teleport());
            getLogger().info("+ teleport");
        }else {
            getCommand("teleport").setExecutor(new disabled());
        }

        // testcommand
        if (getConfig().getBoolean("testcommand.enabled")) {
            getCommand("testcommand").setExecutor(new testcommand());
            getLogger().info("+ testcommand");
        }else {
            getCommand("testcommand").setExecutor(new disabled());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
