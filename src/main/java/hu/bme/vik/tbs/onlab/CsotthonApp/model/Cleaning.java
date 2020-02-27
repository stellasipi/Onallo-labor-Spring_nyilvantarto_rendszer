package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Cleaning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Kitchen_cl kitchen_cl;

    @ManyToOne
    private BigRoom_cl bigRoom_cl;

    @ManyToOne
    private MiddleRoom_cl middleRoom_cl;

    @ManyToOne
    private RestRoom_cl restRoom_cl;

    @ManyToOne
    private Basement_cl basement_cl;

    private Timestamp time;

    @ManyToOne
    private ScoutGroup scoutGroup;

    @ManyToOne
    private User user;

}
