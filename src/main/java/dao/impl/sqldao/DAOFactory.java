package dao.impl.sqldao;


import dao.UserDAO;


public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private UserDAO userDAO = new SQLUserDAO();

    private DAOFactory() {
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
