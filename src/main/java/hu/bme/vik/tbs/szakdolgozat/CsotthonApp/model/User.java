package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @Column(length = 30, unique = true)
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    @ManyToOne
    private ScoutGroup scoutGroup;

    @NotNull
    private Boolean groupLeader;

    @NotNull
    private Boolean scout;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Log> logs = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Cleaning> cleanings = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Maintenance> maintenances = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}
