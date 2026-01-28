package br.dev.peixotim.javaforbukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CalculatorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(args.length < 0){
            sender.sendMessage("§cUso Icorreto do comando para somar dois valores digite /sum <valor 1> <valor 2>");
            return true;
        }

        String n1 = args[0];
        String n2 = args[1];
    try{
        double numberOne = Double.parseDouble(n1);
        double numberTwo = Double.parseDouble(n2);
        double sum = numberOne + numberTwo;

        sender.sendMessage("A soma dos dois valores é " + sum );
        return true;

    }catch(NumberFormatException error){
        sender.sendMessage("§cErro: Você precisa digitar números!");
    }
    return true;
    }
}
