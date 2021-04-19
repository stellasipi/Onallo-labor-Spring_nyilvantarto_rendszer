package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String name;
    private String username;
    private String password;
    private String scoutGroup;
    private Boolean groupLeader;
}
