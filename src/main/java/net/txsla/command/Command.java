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
        getLogger().info("Registering commands:");
        if (getConfig().getBoolean("testcommand.enabled")) {
            getCommand("testcommand").setExecutor(new testcommand());
            getLogger().info("+ testcommand");
        }
        if (getConfig().getBoolean("gamemode.enabled")) {
            getCommand("gamemode").setExecutor(new gamemode());
            getLogger().info("+ gamemode");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
