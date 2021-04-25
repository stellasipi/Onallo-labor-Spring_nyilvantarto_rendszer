package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String name;
    private String username;
    private ScoutGroupDTO scoutGroup;
    private List<RoleDTO> roles;
    private Boolean groupLeader;
    private Boolean scout;
}
