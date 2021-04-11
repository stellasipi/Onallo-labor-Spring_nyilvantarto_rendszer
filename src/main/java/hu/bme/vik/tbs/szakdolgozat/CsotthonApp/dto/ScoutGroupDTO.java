package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.util.Sex;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoutGroupDTO {
    private Integer id;
    private String name;
    private Sex sex;
}
