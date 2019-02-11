package me.devsnox.pingpong.configuration;

import me.devsnox.pingpong.PingPong;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PingConfigurator {

    private PingPong pingPong;

    private File config;
    private YamlConfiguration yamlConfiguration;

    private PingConfiguration pingConfiguration;

    public PingConfigurator(PingPong pingPong) {
        this.pingPong = pingPong;

        this.config = new File(pingPong.getDataFolder() + File.separator + "config.yml");
        this.yamlConfiguration = new UTF8YamlConfiguration();

        try {
            this.yamlConfiguration.load(config);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        String prefix = ChatColor.translateAlternateColorCodes('&', this.yamlConfiguration.getString("prefix") + "§r ");
        String noPermissions = ChatColor.translateAlternateColorCodes('&', this.yamlConfiguration.getString("no-permissions"));
        String consoleMessage = ChatColor.translateAlternateColorCodes('&', this.yamlConfiguration.getString("console-message"));
        String playerNotOnline = ChatColor.translateAlternateColorCodes('&', this.yamlConfiguration.getString("player-not-online"));
        String pingMessage = ChatColor.translateAlternateColorCodes('&', this.yamlConfiguration.getString("ping-message"));
        String pingMessageOther = ChatColor.translateAlternateColorCodes('&', this.yamlConfiguration.getString("ping-message-other"));

        if(yamlConfiguration.getBoolean("prefix-enabled")) {
            noPermissions = prefix + noPermissions;
            consoleMessage = prefix + consoleMessage;
            playerNotOnline = prefix + playerNotOnline;
            pingMessage = prefix + pingMessage;
            pingMessageOther = prefix + pingMessageOther;
        }

        this.pingConfiguration = new PingConfiguration(prefix, noPermissions, consoleMessage, playerNotOnline, pingMessage, pingMessageOther);
    }

    public PingConfiguration getPingConfiguration() {
        return pingConfiguration;
    }
}
