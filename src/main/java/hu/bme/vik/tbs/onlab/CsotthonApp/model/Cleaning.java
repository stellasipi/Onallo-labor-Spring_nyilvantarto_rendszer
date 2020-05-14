package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cleaning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cleaning",cascade = CascadeType.ALL)
    private List<RoomCleaning> roomCleanings=new ArrayList<>();

    @NotNull
    private Timestamp time;

    @ManyToOne
    @NotNull
    private ScoutGroup scoutGroup;

    @ManyToOne
    @NotNull
    private User user;

}
