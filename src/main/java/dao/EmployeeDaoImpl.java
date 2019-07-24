package dao;

import entity.Employee;
import jdbc.ServerConnector;
import jdbc.ServerQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The class implements EmployeeDao interface, retrieves data from MySQL database tables
 * through requests from the mysql_queries.properties file using JDBC.
 *
 * @author Alesia Skarakhod
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private Connection connection = ServerConnector.getInstance().getConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public Employee findEmployeeById(Long id) {
        Employee employee = new Employee();
        try {
            String query = ServerQuery.getInstance().getQuery("getEmployeeById");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee = getEmployee(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {

        List<Employee> employeeList = new ArrayList<>();
        try {
            String query = ServerQuery.getInstance().getQuery("getAllEmployees");
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = getEmployee(resultSet);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return employeeList;
    }

    @Override
    public Employee save(Employee employee) {
        try {
            String query = ServerQuery.getInstance().getQuery("saveEmployee");
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, new java.sql.Date(employee.getDateOfBirth().getTime()));
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return findEmployeeById(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public Boolean remove(Long id) {
        try {
            String query = ServerQuery.getInstance().getQuery("deleteEmployee");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return false;
    }

    private Employee getEmployee(ResultSet resultSet) {
        try {
            Employee employee = new Employee();
            employee.setId(resultSet.getLong(1));
            employee.setName(resultSet.getString(2));
            employee.setLastName(resultSet.getString(3));
            employee.setDateOfBirth(new Date(resultSet.getDate(4).getTime()));
            employee.setEmail(resultSet.getString(5));
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void close(PreparedStatement preparedStatement, ResultSet resultSet) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
