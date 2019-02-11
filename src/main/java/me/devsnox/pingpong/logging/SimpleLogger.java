package me.devsnox.pingpong.logging;

import me.devsnox.pingpong.utils.StringUtils;
import org.bukkit.ChatColor;

import java.util.logging.Level;


/**
 * @author Lars Artmann | LartyHD
 * Created by Lars Artmann | LartyHD on 02.09.2018 13:37.
 * Last edit 02.09.2018
 */
public class SimpleLogger implements DefaultLogger {

    private final java.util.logging.Logger logger;
    private final StringUtils stringUtils;

    public SimpleLogger(final java.util.logging.Logger logger) {
        this.logger = logger;
        this.stringUtils = new StringUtils();
        this.stringUtils.setFormat(ChatColor.YELLOW + "-= ");
    }

    @Override
    public void log(final Level level, final String message) {
        this.logger.log(level, message);
    }

    @Override
    public String format(final String message) {
        return this.stringUtils.format(message);
    }
}
