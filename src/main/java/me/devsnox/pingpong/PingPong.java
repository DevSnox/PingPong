package me.devsnox.pingpong;

import me.devsnox.pingpong.loader.Loader;
import me.devsnox.pingpong.logging.SimpleLogger;
import org.bukkit.plugin.java.JavaPlugin;

public class PingPong extends JavaPlugin {

    @Override
    public void onEnable() { new Loader(this, new SimpleLogger(this.getLogger())).load(); }
}
