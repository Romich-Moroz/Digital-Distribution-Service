package services.exceptions;

public class ServiceAlreadyExistsException extends ServiceException {
    public ServiceAlreadyExistsException() {
        super();
    }

    public ServiceAlreadyExistsException(String message) {
        super(message);
    }

    public ServiceAlreadyExistsException(String message, Throwable cause) {
        super(message, (Exception) cause);
    }

    public ServiceAlreadyExistsException(Throwable cause) {
        super(cause);
    }
    protected ServiceAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
