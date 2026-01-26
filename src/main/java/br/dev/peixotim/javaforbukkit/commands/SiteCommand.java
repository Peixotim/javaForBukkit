package br.dev.peixotim.javaforbukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SiteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {

            if(!player.hasPermission("javaforbukkit.site")) {
                player.sendMessage("§cVocê não tem permissão para isso !");
                return true; //Para finalizar a execução do comando
            }

            sender.sendMessage("§aAcesse o site §ewww.peixotim.website");
        }

        sender.sendMessage("§iOlá Console , aqui está o site §ewww.peixotim.website");

        return true;
    }
}
