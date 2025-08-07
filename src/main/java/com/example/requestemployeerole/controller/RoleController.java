package com.example.requestemployeerole.controller;

import com.example.requestemployeerole.record.RoleDTO;
import com.example.requestemployeerole.service.RoleService;
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
@RequestMapping("/roles")
public class RoleController {

  @Autowired
  private RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping
  public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {
    return roleService.createRole(roleDTO);
  }

  @GetMapping
  public List<RoleDTO> getAllRoles() {
    return roleService.getAllRoles();
  }
}
