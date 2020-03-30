package hu.bme.vik.tbs.onlab.CsotthonApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private ScoutGroupDTO scoutGroup;
    private Boolean groupLeader;
    private Boolean scout;
}
