package me.devsnox.pingpong;

import me.devsnox.pingpong.commands.PingCommand;
import me.devsnox.pingpong.configuration.PingConfiguration;
import me.devsnox.pingpong.configuration.PingConfigurator;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class PingPong extends JavaPlugin implements CommandExecutor {

    private PingConfigurator pingConfigurator;

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
        pingConfigurator = new PingConfigurator(this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "-= register command =-");
        this.getCommand("ping").setExecutor(new PingCommand(this.pingConfigurator.getPingConfiguration()));

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "sucessfully enabled PingPong");

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "{ " + ChatColor.GREEN + "-------" + ChatColor.DARK_GRAY + " }");

        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[ -------------------------------------------------------------- ]");
        Bukkit.getConsoleSender().sendMessage(" ");
    }
}
