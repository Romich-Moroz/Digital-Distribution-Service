package dao.exceptions;

public class DAOInvalidDataException extends DAOException {
    public DAOInvalidDataException () {
        super();
    }
    public DAOInvalidDataException (String message) {
        super(message);
    }

    public DAOInvalidDataException (Exception e) {
        super(e);
    }

    public DAOInvalidDataException (String message, Exception e) {
        super(message, e);
    }

    protected DAOInvalidDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
