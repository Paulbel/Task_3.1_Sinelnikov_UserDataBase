package dao;

import dao.exception.DAOException;
import entity.User;

import java.util.List;


public interface UserDAO {
    List<User> findByInitials(String name, String surname) throws DAOException;
}
