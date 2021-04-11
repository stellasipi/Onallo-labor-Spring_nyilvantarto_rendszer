package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, unique = true)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "room", orphanRemoval = true)
    private List<RoomCleaningItemPairing> roomCleaningItemPairings = new ArrayList<>();

}
