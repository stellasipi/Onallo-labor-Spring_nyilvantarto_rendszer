package hu.bme.vik.tbs.onlab.CsotthonApp.mapper;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.RoomCleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.RoomCleaning;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomCleaningMapper {
    RoomCleaningDTO roomCleaingToRoomCleaningDTO(RoomCleaningDTO roomCleaningDTO);
    RoomCleaning roomCleaningDTOtoRoomCleaning(RoomCleaning roomCleaning);
}
