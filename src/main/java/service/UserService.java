package service;


import entity.User;
import service.exception.ServiceException;

import java.util.List;


public interface UserService {
    List<User> find(String name, String surname) throws ServiceException;
}
