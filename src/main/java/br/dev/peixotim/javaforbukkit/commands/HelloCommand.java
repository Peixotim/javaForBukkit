package br.dev.peixotim.javaforbukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelloCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

            if(sender instanceof Player player){
                player.sendMessage("Hello World!");
                return true;
            }

            sender.sendMessage("Hello World , Console !");
            return true;

    }
}
