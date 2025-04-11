package net.txsla.command.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class gamemode implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return false;
        }

        // switch for /gmc and /gms
        switch (label) {
            case "gmc":
                ((Player) sender).setGameMode(GameMode.CREATIVE);
                sender.sendMessage("Set your game mode to Creative Mode");
                return true;
            case "gms":
                ((Player) sender).setGameMode(GameMode.SURVIVAL);
                sender.sendMessage("Set your game mode to Survival Mode");
                return true;
            default:
                break;
        }

        // validate input
        if (args.length < 1) return false;

        // switch for /gamemode <>
        switch (args[0]) {
            case "adventure":
            case "ADVENTURE":
                ((Player) sender).setGameMode(GameMode.ADVENTURE);
                sender.sendMessage("Set your game mode to Adventure Mode");
                return true;
            case "creative":
            case "CREATIVE":
            case "c":
            case "C":
                ((Player) sender).setGameMode(GameMode.CREATIVE);
                sender.sendMessage("Set your game mode to Creative Mode");
                return true;
            case "spectator":
            case "SPECTATOR":
                ((Player) sender).setGameMode(GameMode.SPECTATOR);
                sender.sendMessage("Set your game mode to Spectator Mode");
                return true;
            case "survival":
            case "SURVIVAL":
                ((Player) sender).setGameMode(GameMode.SURVIVAL);
                sender.sendMessage("Set your game mode to Survival Mode");
                return true;
            default:
                break;
            }
    return false;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (label.equals("gms") || label.equals("gmc")) return null;
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("adventure");
            list.add("creative");
            list.add("spectator");
            list.add("survival");
            return list;
        }
        return null;
    }
}
