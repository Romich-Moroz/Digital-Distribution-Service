package controllers.command;

public class ControllerRuntimeException extends Exception {
    public ControllerRuntimeException () {
        super();
    }
    public ControllerRuntimeException (String message) {
        super(message);
    }

    public ControllerRuntimeException (Exception e) {
        super(e);
    }

    public ControllerRuntimeException (String message, Exception e) {
        super(message, e);
    }

    protected ControllerRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
