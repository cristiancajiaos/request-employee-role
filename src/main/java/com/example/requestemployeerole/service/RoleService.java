package com.example.requestemployeerole.service;

import com.example.requestemployeerole.record.RoleDTO;
import java.util.List;
import java.util.Optional;

public interface RoleService {

  RoleDTO createRole(RoleDTO roleDTO);

  List<RoleDTO> getAllRoles();

  Optional<RoleDTO> getRoleById(Long id);

  RoleDTO deleteRole(Long id);

  RoleDTO updateRole(Long id, RoleDTO roleDTO);

}
