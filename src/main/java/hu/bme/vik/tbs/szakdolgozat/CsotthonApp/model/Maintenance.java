package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Timestamp time;

    @NotNull
    private String comment;

    @NotNull
    @ManyToOne
    private User user;
}
