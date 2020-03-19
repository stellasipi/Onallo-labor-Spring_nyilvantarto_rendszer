package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.LogType;
import lombok.*;
import org.springframework.web.servlet.View;

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
    @JsonManagedReference
    private User user;
}
