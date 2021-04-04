package hu.bme.vik.tbs.onlab.CsotthonApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomCleaningDTO {
    private Integer id;
    private Boolean done;
    private RoomCleaningItemPairingDTO roomCleaningItemPairing;
}
