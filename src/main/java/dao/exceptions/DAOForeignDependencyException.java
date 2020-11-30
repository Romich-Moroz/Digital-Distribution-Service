package dao.exceptions;

public class DAOForeignDependencyException extends DAOException {
    public DAOForeignDependencyException () {
        super();
    }
    public DAOForeignDependencyException (String message) {
        super(message);
    }

    public DAOForeignDependencyException (Exception e) {
        super(e);
    }

    public DAOForeignDependencyException (String message, Exception e) {
        super(message, e);
    }

    protected DAOForeignDependencyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
