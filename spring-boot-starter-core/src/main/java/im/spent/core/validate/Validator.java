package im.spent.core.validate;

import im.spent.core.exception.DataInvalidException;

public class Validator {

    public static void checkValid(Validatable validatable) {
        if (!validatable.valid()) {
            throw new DataInvalidException("0000", "数据不合法");
        }
    }
}
