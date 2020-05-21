package hu.bme.vik.tbs.onlab.CsotthonApp.service;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.CleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.dto.RoomCleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.dto.RoomDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.mapper.CleaningMapper;
import hu.bme.vik.tbs.onlab.CsotthonApp.mapper.RoomCleaningMapper;
import hu.bme.vik.tbs.onlab.CsotthonApp.mapper.RoomMapper;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Cleaning;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Room;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.RoomCleaning;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.*;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.Time;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CleaningService {

    @Autowired
    CleaningRepository cleaningRepository;

    @Autowired
    RoomCleaningRepository roomCleaningRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ScoutGroupRepository scoutGroupRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CleaningItemRepository cleaningItemRepository;

    @Autowired
    private final CleaningMapper cleaningMapper;

    @Autowired
    private final RoomCleaningMapper roomCleaningMapper;

    @Autowired
    private final RoomMapper roomMapper;

    public CleaningService(){
        cleaningMapper = Mappers.getMapper(CleaningMapper.class);
        roomCleaningMapper = Mappers.getMapper(RoomCleaningMapper.class);
        roomMapper = Mappers.getMapper(RoomMapper.class);
        
    }

    public List<CleaningDTO> getAllCleanings(){
        List<Cleaning> cleanings=cleaningRepository.getAllByOrderByTimeDesc();
        List<CleaningDTO> cleaningDTOs=new ArrayList<>();
        for(Cleaning cleaning:cleanings){
            cleaningDTOs.add(cleaningMapper.cleaingToCleaningDTO(cleaning));
        }
        return cleaningDTOs;
    }

    public List<RoomCleaningDTO> getRoomCleaningsForCleanging(Integer cleaningId){
        Cleaning cleaning=cleaningRepository.findById(cleaningId).get();
        List<RoomCleaning> roomCleanings=roomCleaningRepository.findByCleaning(cleaning);
        List<RoomCleaningDTO> roomCleaningDTOs=new ArrayList<>();
        for(RoomCleaning roomCleaning:roomCleanings){
            roomCleaningDTOs.add(roomCleaningMapper.roomCleaingToRoomCleaningDTO(roomCleaning));
        }
        return roomCleaningDTOs;
    }

    public List<RoomCleaningDTO> getRoomCleaningsForCleangingByRoom(Integer cleaningId, String roomName){
        Cleaning cleaning=cleaningRepository.findById(cleaningId).get();
        List<RoomCleaning> roomCleaningsByRoom=roomCleaningRepository.findByCleaningAndRoom(cleaning, roomRepository.findByName(roomName));
        List<RoomCleaningDTO> roomCleaningByRoomDTOs=new ArrayList<>();
        for(RoomCleaning roomCleaningByRoom:roomCleaningsByRoom){
            roomCleaningByRoomDTOs.add(roomCleaningMapper.roomCleaingToRoomCleaningDTO(roomCleaningByRoom));
        }
        return roomCleaningByRoomDTOs;
    }

    public List<RoomDTO> getRooms(){
        List<Room> rooms=roomRepository.findAll();
        List<RoomDTO> roomDTOs=new ArrayList<>();
        for (Room room : rooms) {
            //room.setName(StringUtils.stripAccents(room.getName()));
            roomDTOs.add(roomMapper.roomToRoomDTO(room));
        }
        return roomDTOs;
    }

    //@Transactional
    public List<RoomCleaningDTO> createCleaning(List<RoomCleaningDTO> roomCleaningDTOs){
        Cleaning cleaning=Cleaning.builder()
                .scoutGroup(scoutGroupRepository.findByName("Levendula"))
                .user(userRepository.findByEmail("stella@email.com")) //ezt majd javítani
                .time(Time.getNowInUTC())
                .build();
        cleaningRepository.save(cleaning);

        List<RoomCleaningDTO> persisRoomCleaningDTOs=new ArrayList<>();

        for(RoomCleaningDTO roomCleaningDTO:roomCleaningDTOs){
            RoomCleaning roomCleaning=roomCleaningMapper.roomCleaningDTOtoRoomCleaning(roomCleaningDTO);

            roomCleaning.setRoom(roomRepository.findByName(roomCleaning.getRoom().getName()));
            roomCleaning.setCleaningItem(cleaningItemRepository.findByName(roomCleaning.getCleaningItem().getName()));
            roomCleaning.setCleaning(cleaning);

            roomCleaningRepository.save(roomCleaning);

            persisRoomCleaningDTOs.add(roomCleaningMapper.roomCleaingToRoomCleaningDTO(roomCleaning));
        }
        return persisRoomCleaningDTOs;
    }

    public Boolean deleteCleaning(Integer cleaningId){
        Optional<Cleaning> cleaningOptional=cleaningRepository.findById(cleaningId);
        if(cleaningOptional.isPresent()){
            List<RoomCleaning> roomCleanings=roomCleaningRepository.findByCleaning(cleaningOptional.get());
            for(RoomCleaning roomCleaning:roomCleanings){
                roomCleaningRepository.deleteById(roomCleaning.getId());
            }
            cleaningRepository.deleteById(cleaningId);
            return true;
        }else {
            return false;
        }

    }

}