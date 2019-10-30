package fun.hijklmn.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtil {

    public static void copyProperties(Object dest, Object orig) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.copyProperties(dest, orig);
    }

}
