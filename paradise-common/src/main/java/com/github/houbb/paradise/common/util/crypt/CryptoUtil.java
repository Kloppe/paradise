/*
 * Copyright (c)  2018. houbinbin Inc.
 * iter-blog All rights reserved.
 */

package com.github.houbb.paradise.common.util.crypt;


/**
 *
 * @author houbinbin
 */
public class CryptoUtil {

    /**
     * Generate crypted hash of given password. This method is more secure than
     * {@link #passwordHash(String)} as it will fill the password char array
     * with `\0` once used.
     *
     * See <a href="http://stackoverflow.com/questions/8881291/why-is-char-preferred-over-string-for-passwords-in-java">This SO for more detail</a>
     *
     * @param password the password
     * @return the password hash
     */
    public static char[] passwordHash(char[] password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Generate crypted hash of give password
     *
     * @param password the password
     * @return the password hash
     */
    public static String passwordHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Generate crypted hash of give password
     *
     * @param password the password
     * @return the password hash
     */
    public static String passwordHash(String password, String salt) {
        return BCrypt.hashpw(password, salt);
    }

    public static boolean verifyPassword(String password, String hash) {
        try {
            return BCrypt.checkpw(password, hash);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verifyPassword(char[] password, String hash) {
        try {
            return BCrypt.checkpw(password, hash);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verifyPassword(char[] password, char[] hash) {
        try {
            return BCrypt.checkpw(password, new String(hash));
        } catch (Exception e) {
            return false;
        }
    }


}
