package br.dev.peixotim.javaforbukkit.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.bukkit.Particle;

public class BootsListener implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();

        if(!event.isSneaking()){
            return;
        }

        ItemStack actuallyBoot = player.getInventory().getBoots();

        if (actuallyBoot == null || actuallyBoot.getType() == Material.AIR) {
            return;
        }

        if (actuallyBoot.hasItemMeta() && actuallyBoot.getItemMeta().hasDisplayName()) {
            String nomeDaBota = actuallyBoot.getItemMeta().getDisplayName();

            int levelActually = player.getLevel();


            if(levelActually < 1){
                player.sendMessage("§bYou need at least 1 XP Level to fly!");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 0.5f);
                return;
            }

            if (nomeDaBota.equals("§dBoots Of Hermes")) {
                Vector direction = player.getLocation().getDirection().multiply(2).setY(4);
                player.setVelocity(direction);

                player.playSound(player.getLocation() , Sound.ENTITY_BAT_TAKEOFF,1.0f,1.0f);
                player.spawnParticle(Particle.SOUL_FIRE_FLAME,player.getLocation(),40);

                player.setLevel(levelActually - 1);
                player.sendMessage("§aFly! (Cost: 1 Level)");
            }
        }

    }
}
