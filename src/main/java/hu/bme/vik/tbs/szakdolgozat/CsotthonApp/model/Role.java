package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(length = 30, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
