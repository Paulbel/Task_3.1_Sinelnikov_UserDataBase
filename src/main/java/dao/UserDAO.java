package dao;

import dao.exception.DAOException;
import entity.User;

import java.util.List;


public interface UserDAO {
    void findByInitials(String name, String surname, List<User> users) throws DAOException;
}
