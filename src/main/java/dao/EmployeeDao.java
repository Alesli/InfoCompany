package dao;

import entity.Employee;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findEmployeeById(Long id);

    Employee save(Employee employee);

    Boolean remove(Long id);
}
