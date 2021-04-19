package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String name;
    private String username;
    private ScoutGroupDTO scoutGroup;
    private Boolean groupLeader;
    private Boolean scout;
}
