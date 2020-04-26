package hu.bme.vik.tbs.onlab.CsotthonApp.dto;

import hu.bme.vik.tbs.onlab.CsotthonApp.util.LogType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class LogDTO {
    private Integer id;
    private LogType type;
    private Timestamp time;
    private String comment;
    private UserDTO user;
}
