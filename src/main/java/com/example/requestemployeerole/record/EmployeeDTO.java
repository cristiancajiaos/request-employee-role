package com.example.requestemployeerole.record;

import com.example.requestemployeerole.entity.Role;

public record EmployeeDTO(Long id, String fullName, String username, String password, Role role) {

}
