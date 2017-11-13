package dao;

import dao.exception.DAOException;
import dao.exception.NoUserFoundDAOException;
import entity.User;

import java.util.List;

/**
 * Created by Sinelnikov on 11.11.2017.
 */
public interface UserDAO {
    void findByInitials(String name, String surname, List<User> users) throws DAOException;
    void registration();
    User authorization();
}
