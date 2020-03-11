package hu.bme.vik.tbs.onlab.CsotthonApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Room_cleaning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Cleaning_item cleaning_item;

    private Boolean done;

    @ManyToOne
    private Cleaning cleaning;

}
