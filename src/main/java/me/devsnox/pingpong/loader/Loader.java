package me.devsnox.pingpong.loader;

import me.devsnox.pingpong.commands.PingCommand;
import me.devsnox.pingpong.configuration.MessageHandler;
import me.devsnox.pingpong.exceptions.AlreadyInitializeException;
import me.devsnox.pingpong.logging.Logger;
import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Lars Artmann | LartyHD
 * Created by Lars Artmann | LartyHD on 02.09.2018 13:32.
 * Last edit 02.09.2018
 */
public final class Loader {

    private final JavaPlugin javaPlugin;
    private final Logger logger;

    private MessageHandler messageHandler;

    public Loader(final JavaPlugin javaPlugin, final Logger logger) {
        this.javaPlugin = javaPlugin;
        this.logger = logger;
    }

    public void load() {
        if (this.messageHandler != null) {
            throw new AlreadyInitializeException();
        }

        this.sendHeader();
        this.createConfiguration();
        this.loadConfiguration();
        this.registerCommands();
        this.initializeMetrics();
        this.sendFooter();
    }

    public void reload() {
        this.messageHandler = null;
        this.load();
    }

    private void registerCommands() {
        this.logByFormat("register commands");
        new PingCommand(this.messageHandler);
    }

    private void initializeMetrics() {
        this.logByFormat("register metrics");
        new Metrics(this.javaPlugin);
    }

    private void createConfiguration() {
        final String configName = "messages.yml";
        this.logByFormat("creating " + configName);
        this.javaPlugin.saveResource(configName, false);
    }

    private void loadConfiguration() {
        this.logByFormat("loading configuration");
        this.messageHandler = new MessageHandler(this.javaPlugin.getDataFolder());
    }

    private void sendHeader() {
        this.logger.logSpace();
        this.logger.logDesign();
        this.logger.logSpace();
        final PluginDescriptionFile description = this.javaPlugin.getDescription();
        this.logger.log(ChatColor.DARK_GRAY + "{ " + ChatColor.GREEN + "INFORMATIONS" + ChatColor.DARK_GRAY + " }");
        this.logger.log(this.logger.format(description.getName()));
        this.logByFormat("Authors: " + description.getAuthors());
        this.logByFormat("Version: " + description.getVersion());
        this.logger.log(ChatColor.DARK_RED + "Please report bugs on spigotmc.org per PM");
        this.logger.logSeparator();
        this.logger.logSpace();
        this.logger.log(ChatColor.DARK_GRAY + "{ " + ChatColor.GREEN + "LOADING" + ChatColor.DARK_GRAY + " }");
    }

    private void sendFooter() {
        this.logger.log(ChatColor.GREEN + "Successfully enabled " + this.javaPlugin.getDescription().getFullName());
        this.logger.logSeparator();
        this.logger.logSpace();
        this.logger.logDesign();
        this.logger.logSpace();
    }

    private void logByFormat(final String message) {
        this.logger.log(this.logger.format(message));
    }
}
