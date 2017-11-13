package controller;

import entity.User;
import service.UserService;
import service.exception.ServiceException;
import service.impl.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class FrontController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService  userService = factory.getService();

        String name = request.getParameter(ControllerConstants.nameAttribute);
        String surname = request.getParameter(ControllerConstants.surnameAttribute);
        List <User> user = new ArrayList<>();
        try {
            userService.find(name,surname,user);
            request.setAttribute("userList", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/answer.jsp");
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/smthWrong.jsp");
            request.setAttribute("problem",e.getMessage());
            dispatcher.forward(request, response);
        }


    }
}
