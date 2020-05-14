package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomCleaning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        room.getRoomCleanings().add(this);
    }

    public void setCleaningItem(CleaningItem cleaningItem){
        this.cleaningItem=cleaningItem;
        cleaningItem.getRoomCleanings().add(this);
    }

    public void setCleaning(Cleaning cleaning){
        this.cleaning=cleaning;
        cleaning.getRoomCleanings().add(this);
    }

}
