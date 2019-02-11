package me.devsnox.pingpong.configuration;

public class PingConfiguration {

    private String prefix;

    private String noPermissions;
    private String consoleMessage;
    private String playerNotOnline;

    private String pingMessage;
    private String pingMessageOther;

    public PingConfiguration(String prefix, String noPermissions, String consoleMessage, String playerNotOnline, String pingMessage, String pingMessageOther) {
        this.prefix = prefix;
        this.noPermissions = noPermissions;
        this.consoleMessage = consoleMessage;
        this.playerNotOnline = playerNotOnline;
        this.pingMessage = pingMessage;
        this.pingMessageOther = pingMessageOther;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPermissions() {
        return noPermissions;
    }

    public String getConsoleMessage() {
        return consoleMessage;
    }

    public String getPlayerNotOnline() {
        return playerNotOnline;
    }

    public String getPingMessage() {
        return pingMessage;
    }

    public String getPingMessageOther() {
        return pingMessageOther;
    }
}
