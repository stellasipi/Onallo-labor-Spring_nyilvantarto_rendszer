package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cleaning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "cleaning",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<RoomCleaning> roomCleanings=new ArrayList<>();

    private Timestamp time;

    @ManyToOne
    @JsonManagedReference
    private ScoutGroup scoutGroup;

    @ManyToOne
    @JsonManagedReference
    private User user;

}
