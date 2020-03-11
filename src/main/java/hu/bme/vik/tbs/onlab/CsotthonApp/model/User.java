package hu.bme.vik.tbs.onlab.CsotthonApp.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
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

    private Boolean group_leader;

    private Boolean scout;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Log> logs=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cleaning> cleanings=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Maintanence> maintanences=new ArrayList<>();

}
