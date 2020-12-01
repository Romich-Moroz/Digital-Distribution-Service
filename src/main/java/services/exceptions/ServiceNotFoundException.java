package services.exceptions;

public class ServiceNotFoundException extends ServiceException {
    public ServiceNotFoundException(String message, Exception e)  {
        super(message, e);
    }

    public ServiceNotFoundException() {
        super();
    }

    public ServiceNotFoundException(String message) {
        super(message);
    }

    public ServiceNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ServiceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
