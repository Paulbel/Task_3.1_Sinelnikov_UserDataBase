package service;


import entity.User;
import service.exception.ServiceException;

import java.util.List;

/**
 * Created by Sinelnikov on 11.11.2017.
 */
public interface UserService {
    void find(String name, String surname, List<User> users) throws ServiceException;
}
