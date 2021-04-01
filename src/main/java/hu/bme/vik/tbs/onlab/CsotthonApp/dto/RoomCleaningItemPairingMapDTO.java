package hu.bme.vik.tbs.onlab.CsotthonApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomCleaningItemPairingMapDTO {
    String roomName;
    List<String> cleaningItems;
}
