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
    private Room room;

    @ManyToOne
    @NotNull
    private CleaningItem cleaningItem;

    @NotNull
    private Boolean done;

    @ManyToOne
    @NotNull
    private Cleaning cleaning;

    public void setRoom(Room room){
        this.room=room;
        if(room.getRoomCleanings()==null) room.setRoomCleanings(new ArrayList<>());
        room.getRoomCleanings().add(this);
    }

    public void setCleaningItem(CleaningItem cleaningItem){
        this.cleaningItem=cleaningItem;
        if(cleaningItem.getRoomCleanings()==null) cleaningItem.setRoomCleanings(new ArrayList<>());
        cleaningItem.getRoomCleanings().add(this);
    }

    public void setCleaning(Cleaning cleaning){
        this.cleaning=cleaning;
        if(cleaning.getRoomCleanings()==null) cleaning.setRoomCleanings(new ArrayList<>());
        cleaning.getRoomCleanings().add(this);
    }

}
