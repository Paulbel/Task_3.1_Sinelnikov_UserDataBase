package service.impl;

import service.UserService;


public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private UserService service = new UserServiceImpl();

    private ServiceFactory() {
    }


    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getService() {
        return service;
    }


}
