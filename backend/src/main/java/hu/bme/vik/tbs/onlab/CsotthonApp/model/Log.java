package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import hu.bme.vik.tbs.onlab.CsotthonApp.util.LogType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private LogType type;

    @NotNull
    private Timestamp time;

    private String comment;

    @NotNull
    @ManyToOne
    private User user;
}
