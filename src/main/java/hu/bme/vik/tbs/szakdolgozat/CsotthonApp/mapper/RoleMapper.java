package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RoleDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO roleToRoleDTO(Role role);
    Role roleDTOtoRole(RoleDTO roleDTO);
}
