package br.dev.peixotim.javaforbukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.jetbrains.annotations.NotNull;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;

public class BootsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player player){

            ItemStack bootsOfHermes = new ItemStack(Material.GOLDEN_BOOTS);
            ItemMeta meta = bootsOfHermes.getItemMeta();

            if(meta != null){
                meta.setDisplayName("§dBoots Of Hermes");
                meta.setLore(Arrays.asList("§aThe boots of Hermes, forged from dragon scale gold, allow the wearer to move as if flying!"));

                bootsOfHermes.setItemMeta(meta);
            }

            if(player.getInventory().contains(bootsOfHermes)){
                player.sendMessage("Error, you already own a Hermes boot; it is only granted once per user");
                return true;
            }

            player.getInventory().setItemInMainHand(bootsOfHermes);
            player.giveExpLevels(10);
            player.sendMessage("§dYou have been granted the Boots of Hermes, a revitalizing power, and you have also been given 10 experience points!");

            return true;
        }else{
            sender.sendMessage("§bHello console, unfortunately I can't give you the boots!");
        }
        return true;
    }
}
