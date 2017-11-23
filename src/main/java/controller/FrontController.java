package controller;

import entity.User;
import service.ServiceFactory;
import service.UserService;
import service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// команды уже мог бы запилить
public class FrontController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getService();

        String name = request.getParameter(ControllerConstants.NAME_ATTRIBUTE);
        String surname = request.getParameter(ControllerConstants.SURNAME_ATTRIBUTE);
        try {
            List<User> user = userService.find(name, surname);
            request.setAttribute(ControllerConstants.USER_LIST_ATTRIBUTE, user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/answer.jsp");// неименованая константная строка
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/smthWrong.jsp");
            request.setAttribute(ControllerConstants.PROBLEM_ATTRIBUTE, e.getMessage());
            dispatcher.forward(request, response);// зачем будлировать вызов forward?
        }


    }
}
