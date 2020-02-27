package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class BigRoom_cl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Boolean lomok;

    private Boolean elrendezes;

    private Boolean felmosas;

    @OneToMany(mappedBy = "bigRoom_cl", cascade = CascadeType.ALL)
    private List<Cleaning> cleanings=new ArrayList<>();
}
