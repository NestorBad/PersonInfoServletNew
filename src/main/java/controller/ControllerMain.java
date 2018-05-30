package controller;

import data.PersonDao;
import model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/hello")
public class ControllerMain extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PersonDao personDao;

    @Override
    public void init() throws ServletException {
        personDao = new PersonDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertBook(request, response);
                    break;
                case "/delete":
                    deleteBook(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Person> personList = personDao.listAllPerson();
        request.setAttribute("persons", personList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("PersonForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Person existingPerson = personDao.getPersonById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PersonForm.jsp");
        request.setAttribute("person", existingPerson);
        dispatcher.forward(request, response);

    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String third = request.getParameter("third");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Person newPerson = new Person(first, second, third, phone, email);
        personDao.addPerson(newPerson);
        response.sendRedirect("list");
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id_person"));
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String third = request.getParameter("third");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Person person = new Person(id, first, second, third, phone, email);
        personDao.updatePerson(person);
        response.sendRedirect("list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        Person person = new Person(id);
        personDao.deletePerson(person);
        response.sendRedirect("list");

    }
}

