package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import hu.bme.vik.tbs.onlab.CsotthonApp.util.LogType;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
