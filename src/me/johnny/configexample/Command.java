package me.johnny.configexample;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class Command implements CommandExecutor {

    private Main plugin;
    private FileConfiguration config;

    public Command(Main instance) {
        plugin = instance;
        config = instance.getConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        sender.sendMessage(config.getString("path.to.string"));
        return true;
    }
}
