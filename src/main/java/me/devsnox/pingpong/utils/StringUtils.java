package me.devsnox.pingpong.utils;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lars Artmann | LartyHD
 * Created by Lars Artmann | LartyHD on 02.09.2018 12:55.
 * Last edit 02.09.2018
 */
public final class StringUtils {

    private String prefix = "";
    private String suffix = "";
    private String format = "";

    @NonNull
    public String prefix(final String message) {
        return this.prefix + message;
    }

    @NonNull
    public String suffix(final String message) {
        return this.suffix + message;
    }

    @NonNull
    public String format(final String message) {
        return this.format(this.format, message);
    }

    @NonNull
    private String format(final String format, final String message) {
        final List<Character> characters = new ArrayList<>();

        for (final char c : format.toCharArray()) {
            characters.add(c);
        }

        Collections.reverse(characters);
        return format + message + characters;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(final String suffix) {
        this.suffix = suffix;
    }

    public void setFormat(final String format) {
        this.format = format;
    }
}
