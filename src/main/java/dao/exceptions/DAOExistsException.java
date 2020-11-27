package dao.exceptions;

public class DAOExistsException extends DAOException {
    public DAOExistsException () {
        super();
    }
    public DAOExistsException (String message) {
        super(message);
    }

    public DAOExistsException (Exception e) {
        super(e);
    }

    public DAOExistsException (String message, Exception e) {
        super(message, e);
    }

    protected DAOExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
