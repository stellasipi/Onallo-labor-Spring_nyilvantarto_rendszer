package hu.bme.vik.tbs.onlab.CsotthonApp.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"name", "email"})})
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private String password;

    @ManyToOne
    private ScoutGroup scoutGroup;

    private Boolean groupLeader;

    private Boolean scout;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Log> logs=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cleaning> cleanings=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances=new ArrayList<>();

}
