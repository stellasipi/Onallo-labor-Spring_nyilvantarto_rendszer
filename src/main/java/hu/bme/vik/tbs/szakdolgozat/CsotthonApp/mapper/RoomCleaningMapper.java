package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RoomCleaningDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.RoomCleaning;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomCleaningMapper {
    RoomCleaningDTO roomCleaingToRoomCleaningDTO(RoomCleaning roomCleaning);
    RoomCleaning roomCleaningDTOtoRoomCleaning(RoomCleaningDTO roomCleaningDTO);
}
