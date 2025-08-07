package com.example.requestemployeerole.controller;

import com.example.requestemployeerole.record.EmployeeDTO;
import com.example.requestemployeerole.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping
  public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
    return employeeService.createEmployee(employeeDTO);
  }

  @GetMapping
  public List<EmployeeDTO> getAllEmployees() {
    return employeeService.getAllEmployees();
  }
}
