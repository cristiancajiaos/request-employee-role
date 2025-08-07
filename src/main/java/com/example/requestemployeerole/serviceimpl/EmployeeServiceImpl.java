package com.example.requestemployeerole.serviceimpl;

import com.example.requestemployeerole.entity.Employee;
import com.example.requestemployeerole.record.EmployeeDTO;
import com.example.requestemployeerole.repository.EmployeeRepository;
import com.example.requestemployeerole.repository.RoleRepository;
import com.example.requestemployeerole.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private RoleRepository roleRepository;

  public EmployeeServiceImpl(
      EmployeeRepository employeeRepository,
      RoleRepository roleRepository) {
    this.employeeRepository = employeeRepository;
    this.roleRepository = roleRepository;
  }

  @Override
  public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
    Employee employeeToSave = convertToEntity(employeeDTO);
    Employee savedEmployee = employeeRepository.save(employeeToSave);
    return convertToDTO(savedEmployee);
  }

  private EmployeeDTO convertToDTO(Employee employee) {
    return new EmployeeDTO(employee.getId(), employee.getFullName(), employee.getUsername(),
        employee.getPassword(), employee.getRole());
  }

  private Employee convertToEntity(EmployeeDTO employeeDTO) {
    return new Employee(employeeDTO.id(), employeeDTO.fullName(), employeeDTO.username(),
        employeeDTO.password(), employeeDTO.role());
  }
}
