package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class RestRoom_cl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Boolean tiszta;

    private Boolean wcpapir;

    private Boolean torulkozo;

    private Boolean felmosas;

    @OneToMany(mappedBy = "restRoom_cl", cascade = CascadeType.ALL)
    private List<Cleaning> cleanings=new ArrayList<>();
}
