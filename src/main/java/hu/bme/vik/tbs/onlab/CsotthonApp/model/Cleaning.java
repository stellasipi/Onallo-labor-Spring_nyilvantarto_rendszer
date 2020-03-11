package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cleaning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "cleaning",cascade = CascadeType.ALL)
    private List<RoomCleaning> room_cleanings=new ArrayList<>();

    private Timestamp time;

    @ManyToOne
    private ScoutGroup scoutGroup;

    @ManyToOne
    private User user;

}
