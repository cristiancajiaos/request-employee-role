package com.example.requestemployeerole.serviceimpl;

import com.example.requestemployeerole.entity.Role;
import com.example.requestemployeerole.record.RoleDTO;
import com.example.requestemployeerole.repository.RoleRepository;
import com.example.requestemployeerole.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public RoleDTO createRole(RoleDTO roleDTO) {
    Role roleToCreate = convertToEntity(roleDTO);
    Role createdRole = roleRepository.save(roleToCreate);
    return convertToDTO(createdRole);
  }

  private RoleDTO convertToDTO(Role role) {
    return new RoleDTO(role.getId(), role.getName());
  }

  private Role convertToEntity(RoleDTO roleDTO) {
    return new Role(roleDTO.id(), roleDTO.name());
  }
}
