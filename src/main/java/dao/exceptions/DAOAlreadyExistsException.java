package dao.exceptions;

public class DAOAlreadyExistsException extends DAOException {
    public DAOAlreadyExistsException() {
        super();
    }
    public DAOAlreadyExistsException(String message) {
        super(message);
    }

    public DAOAlreadyExistsException(Exception e) {
        super(e);
    }

    public DAOAlreadyExistsException(String message, Exception e) {
        super(message, e);
    }

    protected DAOAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
