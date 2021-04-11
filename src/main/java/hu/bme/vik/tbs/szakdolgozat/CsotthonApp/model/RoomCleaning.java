package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class RoomCleaning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotNull
    private RoomCleaningItemPairing roomCleaningItemPairing;

    @NotNull
    private Boolean done;

    @ManyToOne
    @NotNull
    private Cleaning cleaning;

    public void setRoomCleaningItemPairing(RoomCleaningItemPairing roomCleaningItemPairing) {
        this.roomCleaningItemPairing = roomCleaningItemPairing;
        if (roomCleaningItemPairing.getRoomCleanings() == null)
            roomCleaningItemPairing.setRoomCleanings(new ArrayList<>());
        roomCleaningItemPairing.getRoomCleanings().add(this);

    }

    public void setCleaning(Cleaning cleaning) {
        this.cleaning = cleaning;
        if (cleaning.getRoomCleanings() == null) cleaning.setRoomCleanings(new ArrayList<>());
        cleaning.getRoomCleanings().add(this);
    }

}
