package net.txsla.command;

import org.bukkit.plugin.java.JavaPlugin;
import net.txsla.command.commands.*;

public final class Command extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        // only register enabled commands
        if (getConfig().getBoolean("testcommand.enabled")) {
            getCommand("testcommand").setExecutor(new testcommand());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
