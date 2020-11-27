package services.exceptions;

public class ServiceInvalidDataException extends ServiceException {
    public ServiceInvalidDataException(String message, Exception e)  {
        super(message, e);
    }

    public ServiceInvalidDataException() {
        super();
    }

    public ServiceInvalidDataException(String message) {
        super(message);
    }

    public ServiceInvalidDataException(Throwable cause) {
        super(cause);
    }

    protected ServiceInvalidDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
