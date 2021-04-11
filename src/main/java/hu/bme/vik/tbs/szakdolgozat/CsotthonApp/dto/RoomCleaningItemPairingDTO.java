package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomCleaningItemPairingDTO {
    private Integer id;
    private String roomName;
    private String cleaningItemName;
}
