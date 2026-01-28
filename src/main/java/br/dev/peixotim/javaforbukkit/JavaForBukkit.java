package br.dev.peixotim.javaforbukkit;

import br.dev.peixotim.javaforbukkit.commands.*;
import br.dev.peixotim.javaforbukkit.listener.BootsListener;
import br.dev.peixotim.javaforbukkit.listener.PlacaInteracaoLixeiraListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public final class JavaForBukkit extends JavaPlugin {

    private static FileConfiguration config;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Plugin Initialized !");


        saveDefaultConfig();
        config = getConfig();

        getCommand("hello").setExecutor(new HelloCommand());
        getCommand("site").setExecutor(new SiteCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("Sum").setExecutor(new CalculatorCommand());
        getCommand("boots").setExecutor(new BootsCommand());

        Bukkit.getPluginManager().registerEvents(new PlacaInteracaoLixeiraListener(),this);
        Bukkit.getPluginManager().registerEvents(new BootsListener(),this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Plugin Finalized !");
    }

    public static FileConfiguration getPluginConfig(){
        return config;
    }
}
