package service.impl;


import dao.UserDAO;
import dao.exception.DAOException;
import dao.impl.sqldao.DAOFactory;
import entity.User;
import service.UserService;
import service.exception.ServiceException;
import service.exception.WrongParametersException;
import service.validator.Validator;

import java.util.List;


public class UserServiceImpl implements UserService {
    public void find(String name, String surname, List<User> users) throws ServiceException {
        //validate
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        try {
            Validator validator = new Validator();
            if (validator.validate(name, surname)) {
                userDAO.findByInitials(name, surname, users);
            } else {
                throw new WrongParametersException();
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
