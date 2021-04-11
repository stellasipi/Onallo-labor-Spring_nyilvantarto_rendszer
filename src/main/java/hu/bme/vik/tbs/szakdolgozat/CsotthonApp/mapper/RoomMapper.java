package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RoomDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDTO roomToRoomDTO(Room room);
    Room roomDTOtoRoom(RoomDTO roomDTO);
}
