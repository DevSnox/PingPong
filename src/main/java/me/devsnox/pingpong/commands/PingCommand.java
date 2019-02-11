package me.devsnox.pingpong.commands;

import me.devsnox.pingpong.configuration.PingConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    private PingConfiguration pingConfiguration;

    public PingCommand(PingConfiguration pingConfiguration) {
        this.pingConfiguration = pingConfiguration;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            if(sender instanceof Player) {
                if(sender.hasPermission("pingpong.ping")) {
                    Player player = ((Player) sender).getPlayer();
                    player.sendMessage(this.pingConfiguration.getPingMessage().replaceAll("%ping%", String.valueOf(((CraftPlayer)player).getHandle().ping)));
                    return true;
                }
                sender.sendMessage(this.pingConfiguration.getNoPermissions());
                return false;
            }
            sender.sendMessage(this.pingConfiguration.getConsoleMessage());
            return false;
        } else if(args.length == 1) {
            if(sender.hasPermission("pingpong.ping.other")) {
                if(Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    sender.sendMessage(this.pingConfiguration.getPingMessageOther()
                            .replaceAll("%player%", target.getName())
                            .replaceAll("%ping%", String.valueOf(((CraftPlayer)target).getHandle().ping)));
                } else {
                    sender.sendMessage(this.pingConfiguration.getPlayerNotOnline().replaceAll("%player%", args[0]));
                }
            } else {
                sender.sendMessage(this.pingConfiguration.getNoPermissions());
            }
        }
        return false;
    }
}
