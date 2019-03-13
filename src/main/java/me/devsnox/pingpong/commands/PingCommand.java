package me.devsnox.pingpong.commands;

import me.devsnox.pingpong.configuration.MessageHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    private final MessageHandler messageHandler;

    public PingCommand(final MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                if (sender.hasPermission("pingpong.ping")) {
                    final Player player = ((Player) sender).getPlayer();

                    player.sendMessage(this.messageHandler.get("ping")
                            .replaceAll("%ping%", String.valueOf(this.getPing(player))));

                    return true;
                }

                sender.sendMessage(this.messageHandler.get("error.no-permissions"));
                return false;
            }
            sender.sendMessage(this.messageHandler.get("error.console-ping-request"));
            return false;
        } else if (args.length == 1) {
            if (sender.hasPermission("pingpong.ping.other")) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    final Player target = Bukkit.getPlayer(args[0]);

                    sender.sendMessage(this.messageHandler.get("ping.other")
                            .replaceAll("%player%", target.getName())
                            .replaceAll("%ping%", String.valueOf(getPing(target))));
                } else {
                    sender.sendMessage(this.messageHandler.get("error.target-not-online").replaceAll("%player%", args[0]));
                }
            } else {
                sender.sendMessage(this.messageHandler.get("error.no-permissions"));
            }
        }
        return false;
    }

    private int getPing(Player player) {
        return ((CraftPlayer) player).getHandle().ping;
    }
}
