package im.spent.util;

import im.spent.core.exception.DataInvalidException;
import im.spent.core.spec.Validatable;

public class ValidateUtil {

    public static void checkEntityValid(Validatable validatable) {
        if (!validatable.valid()) {
            throw new DataInvalidException("数据不合法");
        }
    }

    public static boolean isNotBlank(String str) {
        return StringUtil.isNotBlank(str);
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }
}
