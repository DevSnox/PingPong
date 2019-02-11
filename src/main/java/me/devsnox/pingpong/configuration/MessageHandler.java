package me.devsnox.pingpong.configuration;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessageHandler {

    private final File config;
    private final YamlConfiguration yamlConfiguration;

    public MessageHandler(final File dataFolder) {
        this.config = new File(dataFolder + File.separator + "messages.yml");
        this.yamlConfiguration = new UTF8YamlConfiguration();

        try {
            this.yamlConfiguration.load(this.config);
        } catch (final IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public String get(final String id) {
        return new StringBuilder()
                .append(this.yamlConfiguration.getBoolean("prefix-enabled") ? this.color(this.yamlConfiguration.getString("prefix")) : "")
                .append(this.yamlConfiguration.contains(id) ? this.color(this.yamlConfiguration.getString(id.toLowerCase())) : "")
        .toString();
    }

    private String color(final String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
