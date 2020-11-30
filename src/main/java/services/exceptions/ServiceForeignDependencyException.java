package services.exceptions;

public class ServiceForeignDependencyException extends ServiceException {
    public ServiceForeignDependencyException(String message, Exception e)  {
        super(message, e);
    }

    public ServiceForeignDependencyException() {
        super();
    }

    public ServiceForeignDependencyException(String message) {
        super(message);
    }

    public ServiceForeignDependencyException(Throwable cause) {
        super(cause);
    }

    protected ServiceForeignDependencyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
