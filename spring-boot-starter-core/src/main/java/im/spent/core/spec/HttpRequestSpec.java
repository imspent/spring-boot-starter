package im.spent.core.spec;

import im.spent.core.validate.Validatable;

public abstract class HttpRequestSpec<T> implements Validatable {

    public abstract T convertToEntity();

    public abstract void checkValid();
}
