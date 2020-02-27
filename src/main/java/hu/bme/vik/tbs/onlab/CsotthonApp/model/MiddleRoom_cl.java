package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class MiddleRoom_cl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Boolean elrendezes;

    private Boolean faliujsag;

    private Boolean vitrin;

    private Boolean raktar;

    private Boolean felmosas;

    @OneToMany(mappedBy = "middleRoom_cl", cascade = CascadeType.ALL)
    private List<Cleaning> cleanings=new ArrayList<>();
}
