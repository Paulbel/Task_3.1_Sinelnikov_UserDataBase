package service.exception;

public class WrongParametersException extends ServiceException {
    public WrongParametersException() {
        super();
    }

    public WrongParametersException(String message) {
        super(message);
    }

    public WrongParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongParametersException(Throwable cause) {
        super(cause);
    }
}
