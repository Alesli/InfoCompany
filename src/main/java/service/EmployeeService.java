package service;

import entity.Employee;

import javax.validation.Valid;
import java.util.List;

public interface EmployeeService {

    Employee findEmployeeById(Long id);

    List<Employee> getAll();

    Employee save(Employee employee);

    Boolean remove(Long id);
}
