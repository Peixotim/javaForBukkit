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

        if(!player.isSneaking()){
            return;
        }

        ItemStack actuallyBoot = player.getInventory().getBoots();

        if (actuallyBoot == null || actuallyBoot.getType() == Material.AIR) {
            return;
        }

        if (actuallyBoot.hasItemMeta() && actuallyBoot.getItemMeta().hasDisplayName()) {
            String nomeDaBota = actuallyBoot.getItemMeta().getDisplayName();

            var getExp = player.getExp();

            if(getExp < 0.0){
                player.sendMessage("§bYou lack the experience to level up, kill mobs, kill enemies and gain experience so you can use the skill granted by Hermes");
                return;
            }

            if (nomeDaBota.equals("§dBoots Of Hermes")) {
                Vector direction = player.getLocation().getDirection().multiply(2).setY(4);
                player.setVelocity(direction);

                player.playSound(player.getLocation() , Sound.ENTITY_BAT_TAKEOFF,1.0f,1.0f);
                player.spawnParticle(Particle.CLOUD,player.getLocation(),10);

                player.setExp((float) (getExp - 1.0));

                player.sendMessage("Fly!");
            }
        }

    }
}
