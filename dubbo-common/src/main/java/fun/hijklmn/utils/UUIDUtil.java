package fun.hijklmn.utils;

import java.util.Random;
import java.util.UUID;

public class UUIDUtil {

    private static final String nonStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }

    public static String nonStr(int length) {
        if (length < 1) return null;
        StringBuilder stringBuilder = new StringBuilder();
        while (length > 0) {
            length --;
            stringBuilder.append(nonStr.charAt(new Random().nextInt(nonStr.length())));
        }
        return stringBuilder.toString();
    }

}
