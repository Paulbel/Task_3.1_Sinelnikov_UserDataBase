package service.impl;


import dao.UserDAO;
import dao.exception.DAOException;
import dao.DAOFactory;
import entity.User;
import service.UserService;
import service.exception.ServiceException;
import service.exception.WrongParametersException;
import service.validator.Validator;

import java.util.List;


public class UserServiceImpl implements UserService {
    public List<User> find(String name, String surname) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        try {
            Validator validator = new Validator();
            if (validator.validate(name, surname)) {
                return userDAO.findByInitials(name, surname);
            } else {
                throw new WrongParametersException("Incorrect data, check it!");
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
