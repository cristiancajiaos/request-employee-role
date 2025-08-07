package com.example.requestemployeerole.service;

import com.example.requestemployeerole.record.RoleDTO;
import java.util.List;

public interface RoleService {

  RoleDTO createRole(RoleDTO roleDTO);

  List<RoleDTO> getAllRoles();

}
