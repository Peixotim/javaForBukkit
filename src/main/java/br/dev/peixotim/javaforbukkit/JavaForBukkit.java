package br.dev.peixotim.javaforbukkit;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;


public final class JavaForBukkit extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Plugin Initialized !");
    }

    public String userName(){
        return "Hello";
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (label.equalsIgnoreCase("hello")) {
            if (sender instanceof Player player) {
                int ping = player.getPing();

                if (ping < 100) {
                    player.setExp(1000);
                    player.sendMessage("Congratulation !");
                } else {
                    sender.sendMessage("Hello Console !");
                }

                player.sendMessage("Hello your ping is : " + ping);
            }
        }
        return true;
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Plugin Finalized !");
    }
}
