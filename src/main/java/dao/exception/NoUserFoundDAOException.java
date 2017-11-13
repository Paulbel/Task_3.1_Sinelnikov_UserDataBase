package dao.exception;

public class NoUserFoundDAOException extends DAOException {
    public NoUserFoundDAOException() {
    }

    public NoUserFoundDAOException(String message) {
        super(message);
    }

    public NoUserFoundDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUserFoundDAOException(Throwable cause) {
        super(cause);
    }
}
