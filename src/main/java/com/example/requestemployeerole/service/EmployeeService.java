package com.example.requestemployeerole.service;

import com.example.requestemployeerole.record.EmployeeDTO;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

  EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

  List<EmployeeDTO> getAllEmployees();

  Optional<EmployeeDTO> getEmployeeById(Long id);

}
