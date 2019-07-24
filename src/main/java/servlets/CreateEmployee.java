package servlets;

import entity.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@WebServlet(urlPatterns = "/add")
public class CreateEmployee extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputDay = req.getParameter("dd");
        String inputMonth = req.getParameter("mm");
        String imputDate =
                (inputDay.length() == 1 ? "0".concat(inputDay) : inputDay) +
                        "." +
                        (inputMonth.length() == 1 ? "0".concat(inputMonth) : inputMonth) +
                        "." +
                        req.getParameter("yyyy");

        Date dateBirth = null;
        try {
            dateBirth = new SimpleDateFormat("dd.MM.yyyy").parse(imputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Employee employeeUpdated = Employee
                .builder()
                .name(req.getParameter("name"))
                .lastName(req.getParameter("lastName"))
                .dateOfBirth(dateBirth)
                .email(req.getParameter("email"))
                .build();
        if (employeeUpdated.getName().isEmpty()) {
            req.setAttribute("errors", "<ul> <li> Field 'Name' is empty! </li></ul>");
            doGet(req, resp);
        } else if (employeeUpdated.getLastName().isEmpty()) {
            req.setAttribute("errors", "<ul> <li> Field 'Last name' is empty! </li></ul>");
            doGet(req, resp);
        } else {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employeeUpdated);

            if (constraintViolations.isEmpty()) {
                Employee employeeSaved = employeeService.save(employeeUpdated);
                req.setAttribute("employee", employeeSaved);
                doGet(req, resp);

            } else {
                StringBuilder errors = new StringBuilder("<ul>");
                for (ConstraintViolation<Employee> constraintViolation : constraintViolations) {
                    errors
                            .append("<li>")
                            .append(constraintViolation.getMessage())
                            .append("</li>");
                }
                errors.append("</ul>");
                req.setAttribute("errors", errors.toString());
                doGet(req, resp);
            }
        }
    }
}

