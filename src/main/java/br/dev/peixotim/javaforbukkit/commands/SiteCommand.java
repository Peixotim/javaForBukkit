package br.dev.peixotim.javaforbukkit.commands;

import br.dev.peixotim.javaforbukkit.JavaForBukkit;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SiteCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        var permission = JavaForBukkit.getPluginConfig().getBoolean("Site.Permission");
        var message = JavaForBukkit.getPluginConfig().getString("Site.Message");

        if(sender instanceof Player player) {

            if(permission && !player.hasPermission("javaforbukkit.site")) {
                player.sendMessage("§cVocê não tem permissão para isso !");
                return true;
            }

            sender.sendMessage(message);
        }

        sender.sendMessage(LegacyComponentSerializer.legacy('&').deserialize(message));

        return true;
    }
}
