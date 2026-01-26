package br.dev.peixotim.javaforbukkit;

import br.dev.peixotim.javaforbukkit.commands.HelloCommand;
import br.dev.peixotim.javaforbukkit.commands.PingCommand;
import br.dev.peixotim.javaforbukkit.commands.SiteCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class JavaForBukkit extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Plugin Initialized !");
        getCommand("Hello").setExecutor(new HelloCommand());
        getCommand("Site").setExecutor(new SiteCommand());
        getCommand("Ping").setExecutor(new PingCommand());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Plugin Finalized !");
    }
}
