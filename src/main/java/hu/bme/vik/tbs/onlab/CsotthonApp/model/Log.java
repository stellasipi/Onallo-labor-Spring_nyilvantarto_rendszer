package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import hu.bme.vik.tbs.onlab.CsotthonApp.util.LogType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Log {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private LogType type;

    private Timestamp time;

    private String comment;

    @ManyToOne
    private User user;
}
