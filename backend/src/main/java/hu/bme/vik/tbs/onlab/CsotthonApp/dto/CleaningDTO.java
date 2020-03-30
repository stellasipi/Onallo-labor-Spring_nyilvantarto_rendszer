package hu.bme.vik.tbs.onlab.CsotthonApp.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CleaningDTO {
    private Integer id;
    private Timestamp time;
    private ScoutGroupDTO scoutGroup;
    private UserDTO user;
}
