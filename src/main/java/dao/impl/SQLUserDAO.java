package dao.impl;


import dao.UserDAO;
import dao.exception.DAOException;
import dao.exception.NoUserFoundDAOException;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDAO implements UserDAO {
    public List<User> findByInitials(String name, String surname) throws DAOException {
        try (Connection connection = SQLConnectionCreator.createConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQIDAOConstants.FIND_USER_BY_INITIALS_SURNAME)) {

            statement.setString(SQIDAOConstants.FIND_USER_BY_INITIALS_NAME_INDEX, name);
            statement.setString(SQIDAOConstants.FIND_USER_BY_INITIALS_SURNAME_INDEX, surname);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.isBeforeFirst()) {
                    return getUsersFromResultSet(resultSet);
                } else {
                    throw new NoUserFoundDAOException("No matches in database found, please try again!");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DAOException("Error accured with connecting to database!", e);
        }
    }


    private List<User> getUsersFromResultSet(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            String name = resultSet.getString(SQIDAOConstants.USER_TABLE_NAME_COLUMN_INDEX);
            String surname = resultSet.getString(SQIDAOConstants.USER_TABLE_SURNAME_COLUMN_INDEX);
            String phone = resultSet.getString(SQIDAOConstants.USER_TABLE_PHONE_COLUMN_INDEX);
            String email = resultSet.getString(SQIDAOConstants.USER_TABLE_EMAIL_COLUMN_INDEX);
            user.setName(name);
            user.setSurname(surname);
            user.setPhoneNumber(phone);
            user.setEmail(email);
            users.add(user);
        }
        return users;
    }
}
