package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Kitchen_cl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Boolean konyhapult;

    private Boolean konyhabutor;

    private Boolean mosogatas;

    private Boolean felmosas;

    @OneToMany(mappedBy="kitchen_cl", cascade = CascadeType.ALL)
    private List<Cleaning> cleanings=new ArrayList<>();
}
