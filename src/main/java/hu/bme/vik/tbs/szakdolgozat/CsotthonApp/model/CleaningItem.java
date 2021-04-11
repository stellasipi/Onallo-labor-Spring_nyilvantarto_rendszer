package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class CleaningItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(length = 30, unique = true)
    private String name;

    @OneToMany(mappedBy = "cleaningItem", orphanRemoval = true)
    private List<RoomCleaningItemPairing> roomCleaningItemPairings = new ArrayList<>();

}
