package com.example.requestemployeerole.service;

import com.example.requestemployeerole.record.EmployeeDTO;
import java.util.List;

public interface EmployeeService {

  EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

  List<EmployeeDTO> getAllEmployees();
}
