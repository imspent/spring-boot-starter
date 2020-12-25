package im.spent.core.validate;

import im.spent.core.exception.DataInvalidException;

public interface Validatable {

    void checkValid() throws DataInvalidException;
}
