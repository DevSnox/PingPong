package me.devsnox.pingpong;

import me.devsnox.pingpong.commands.PingCommand;
import me.devsnox.pingpong.configuration.MessageHandler;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class PingPong extends JavaPlugin implements CommandExecutor {

    private MessageHandler messageHandler;

    @Override
    public void onEnable() {
        this.saveConfig();
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[ -------------------------------------------------------------- ]");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "{ " + ChatColor.GREEN + "INFORMATIONS" + ChatColor.DARK_GRAY + " }");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "-= PingPong =-  ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "-= Author: DevSnox =-");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "-= Version: 1.1 =-");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "Please report bugs on spigotmc.org per PM");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "{ " + ChatColor.GREEN + "------------" + ChatColor.DARK_GRAY + " }");
        Bukkit.getConsoleSender().sendMessage(" ");

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "{ " + ChatColor.GREEN + "LOADING" + ChatColor.DARK_GRAY + " }");

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "-= register metrics =-");
        new Metrics(this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "-= creating config.yml =-");
        this.saveResource("config.yml", false);

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "-= loading configurations =-");
        this.messageHandler = new MessageHandler(this.getDataFolder());

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "-= register command =-");
        this.getCommand("ping").setExecutor(new PingCommand(this.messageHandler));

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "sucessfully enabled PingPong");

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "{ " + ChatColor.GREEN + "-------" + ChatColor.DARK_GRAY + " }");

        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[ -------------------------------------------------------------- ]");
        Bukkit.getConsoleSender().sendMessage(" ");
    }
}
