package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class RoomCleaningItemPairing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @NotNull
    private Room room;

    @ManyToOne
    @NotNull
    private CleaningItem cleaningItem;

    @OneToMany(orphanRemoval = true, mappedBy = "roomCleaningItemPairing")
    private List<RoomCleaning> roomCleanings = new ArrayList<>();

}
