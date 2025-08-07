package com.example.requestemployeerole.controller;

import com.example.requestemployeerole.record.RoleDTO;
import com.example.requestemployeerole.service.RoleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/{id}")
  public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
      Optional<RoleDTO> foundRole = roleService.getRoleById(id);
      return foundRole.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
    try {
      RoleDTO updatedRole = roleService.updateRole(id, roleDTO);
      return ResponseEntity.ok(updatedRole);
    } catch (Exception e) {
      System.err.println("Error: " + e);
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<RoleDTO> deleteRole(@PathVariable Long id) {
    try {
      RoleDTO foundRole = roleService.deleteRole(id);
      return ResponseEntity.ok(foundRole);
    } catch (Exception e) {
      System.err.println("Error: " + e);
      return ResponseEntity.notFound().build();
    }
  }
}
