package hu.bme.vik.tbs.onlab.CsotthonApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.LogType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class LogDTO {
    private Integer id;
    private LogType type;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="Europe/Budapest")
    private Timestamp time;

    private String comment;
    private UserDTO user;
}
