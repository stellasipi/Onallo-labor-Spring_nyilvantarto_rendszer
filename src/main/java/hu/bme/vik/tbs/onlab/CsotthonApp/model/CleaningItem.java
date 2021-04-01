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
public class CleaningItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(length = 30, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cleaningItem",cascade = CascadeType.ALL)
    private List<RoomCleaningItemPairing> roomCleaningItemPairings=new ArrayList<>();

}
