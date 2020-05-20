package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 30, unique = true)
    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room",cascade = CascadeType.ALL)
    private List<RoomCleaning> roomCleanings=new ArrayList<>();

}
