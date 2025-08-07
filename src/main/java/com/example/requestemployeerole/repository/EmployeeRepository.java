package com.example.requestemployeerole.repository;

import com.example.requestemployeerole.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
