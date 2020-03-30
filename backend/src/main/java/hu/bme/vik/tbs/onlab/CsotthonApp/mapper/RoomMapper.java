package hu.bme.vik.tbs.onlab.CsotthonApp.mapper;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.RoomDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDTO roomToRoomDTO(Room room);
    Room roomDTOtoRoom(RoomDTO roomDTO);
}
