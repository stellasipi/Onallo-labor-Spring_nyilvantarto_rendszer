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
public class RoomCleaningItemPairing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotNull
    private Room room;

    @ManyToOne
    @NotNull
    private CleaningItem cleaningItem;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "roomCleaningItemPairing",cascade = CascadeType.ALL)
    private List<RoomCleaning> roomCleanings=new ArrayList<>();

    public void setRoom(Room room){
        this.room=room;
        if(room.getRoomCleaningItemPairings()==null) room.setRoomCleaningItemPairings(new ArrayList<>());
        room.getRoomCleaningItemPairings().add(this);
    }

    public void setCleaningItem(CleaningItem cleaningItem){
        this.cleaningItem=cleaningItem;
        if(cleaningItem.getRoomCleaningItemPairings()==null) cleaningItem.setRoomCleaningItemPairings(new ArrayList<>());
        cleaningItem.getRoomCleaningItemPairings().add(this);
    }

}
