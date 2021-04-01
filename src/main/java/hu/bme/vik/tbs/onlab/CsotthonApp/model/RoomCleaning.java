package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    //@NotNull
    private Cleaning cleaning;

    public void setRoomCleaningItemPairing(RoomCleaningItemPairing roomCleaningItemPairing) {
        this.roomCleaningItemPairing = roomCleaningItemPairing;
        if (roomCleaningItemPairing.getRoomCleanings() == null)
            roomCleaningItemPairing.setRoomCleanings(new ArrayList<>());
        roomCleaningItemPairing.getRoomCleanings().add(this);

    }

    public void setCleaning(Cleaning cleaning) {
        this.cleaning = cleaning;
        if (cleaning != null) {
            if (cleaning.getRoomCleanings() == null) cleaning.setRoomCleanings(new ArrayList<>());
            cleaning.getRoomCleanings().add(this);
        }
    }

}
