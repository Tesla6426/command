package net.txsla.command.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class teleport implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return false;
        }

        Player p = (Player) sender;

        // default to player's current coordinates
        double[] coord = new double[3];
        World world = p.getWorld();
        coord[0] = p.getX();
        coord[1] = p.getY();
        coord[2] = p.getZ();

        // parse input
        try {
            // coords
            for (int i = 0; i<3; i++) {
                if (!args[i].equals("~")) {
                    if (args[i].matches("(^-?[0-9]*\\.[0-9]+)|(^-?[0-9]+)")) coord[i] = Double.parseDouble( args[i] );
                    if (args[i].matches("(^~-?[0-9]*\\.[0-9]+)|(^~-?[0-9]+)")) coord[i] += Double.parseDouble( args[i].substring(1));
                }
            }

            if ((args.length >= 4) && (args[3] != null) ) {
                world = p.getServer().getWorld(args[3]);
            }

        } catch (Exception e) {return false;}

        // teleport player
        try {
            p.teleport(new Location(world, coord[0], coord[1], coord[2]));
            sender.sendMessage(ChatColor.GREEN + "Teleporting...");
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "Failed to teleport player!");
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
                list.add("~");
                list.add("~ ~");
                list.add("~ ~ ~");
                list.add("" + Math.round(p.getX()) + " " + Math.round(p.getY()) + " " + Math.round(p.getZ()));
                break;
            case 2:
                list.add("~");
                list.add("~ ~");
                list.add("" + Math.round(p.getY()) + " " +  Math.round(p.getZ()) );
                break;
            case 3:
                list.add("~");
                list.add("" + Math.round(p.getZ()));
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
}
