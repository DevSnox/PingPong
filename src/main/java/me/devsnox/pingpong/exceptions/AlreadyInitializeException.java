package me.devsnox.pingpong.exceptions;

/**
 * @author Lars Artmann | LartyHD
 * Created by Lars Artmann | LartyHD on 02.09.2018 14:05.
 * Last edit 02.09.2018
 */
public class AlreadyInitializeException extends RuntimeException {

    public AlreadyInitializeException() {
    }

    public AlreadyInitializeException(final String var1) {
        super(var1);
    }
}
