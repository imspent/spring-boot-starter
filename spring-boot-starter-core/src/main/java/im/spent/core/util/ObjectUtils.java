package im.spent.core.util;

import org.springframework.lang.Nullable;

public class ObjectUtils extends org.springframework.util.ObjectUtils {

    public static boolean isNotEmpty(@Nullable Object obj) {
        return !isEmpty(obj);
    }
}
