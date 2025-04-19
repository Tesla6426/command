package net.txsla.command.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class effect implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return false;
        }

        //
        //  Remind me to finish this later
        //


        Player p = (Player) sender;

        // clear all effects
        if ((args.length == 1) && args[0].equals("clear")) {
            clear_all_effects(p);
            return true;
        }





        return true;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) return null;
        Player p = (Player) sender;

        List<String> list = new ArrayList<>();
        switch (args.length) {
            case 1:
                list.add("give");
                list.add("clear");
                break;
            case 2:
                for (PotionEffectType effects : PotionEffectType.values()) {
                    list.add( effects.getName() );
                }
                break;
            case 3:

                break;
            case 4:
                for (World world : sender.getServer().getWorlds()) {
                    list.add(world.getName());
                }
                break;
            default:
                return null;
        }
        return list;
    }
    public static void clear_effect(Player p, String effect) {

    }
    public static void give_effect(Player p, PotionEffectType type, int strength, int duration) {
        PotionEffect effect = new PotionEffect(type, duration, strength);


    }
    public static void clear_all_effects(Player p) {
        p.getActivePotionEffects().clear();
    }
}
