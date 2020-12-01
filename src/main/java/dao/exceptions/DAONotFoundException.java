package dao.exceptions;

public class DAONotFoundException extends DAOException {
    public DAONotFoundException () {
        super();
    }
    public DAONotFoundException (String message) {
        super(message);
    }

    public DAONotFoundException (Exception e) {
        super(e);
    }

    public DAONotFoundException (String message, Exception e) {
        super(message, e);
    }

    protected DAONotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
