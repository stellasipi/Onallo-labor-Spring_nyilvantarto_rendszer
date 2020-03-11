package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cleaning_item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "cleaning_item",cascade = CascadeType.ALL)
    private List<Room_cleaning> room_cleanings=new ArrayList<>();

}
