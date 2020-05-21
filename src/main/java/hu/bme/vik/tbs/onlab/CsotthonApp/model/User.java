package hu.bme.vik.tbs.onlab.CsotthonApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    //a Hibernateben csak lengthtel együtt működik a unique
    @Column(length = 30, unique = true)
    @NotNull
    private String email;

    @NotNull
    private String password;


    @NotNull
    @ManyToOne
    private ScoutGroup scoutGroup;

    @NotNull
    private Boolean groupLeader;

    @NotNull
    private Boolean scout;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Log> logs=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cleaning> cleanings=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances=new ArrayList<>();

}
