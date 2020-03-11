package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<RoomCleaning> room_cleanings=new ArrayList<>();
}
