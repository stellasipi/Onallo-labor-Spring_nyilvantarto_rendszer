package hu.bme.vik.tbs.onlab.CsotthonApp.service;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.CleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.dto.RoomCleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.mapper.CleaningMapper;
import hu.bme.vik.tbs.onlab.CsotthonApp.mapper.RoomCleaningMapper;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Cleaning;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.RoomCleaning;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.CleaningRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.RoomCleaningRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CleaningService {

    @Autowired
    CleaningRepository cleaningRepository;

    @Autowired
    RoomCleaningRepository roomCleaningRepository;

    @Autowired
    private final CleaningMapper cleaningMapper;

    @Autowired
    private final RoomCleaningMapper roomCleaningMapper;

    public CleaningService(){
        cleaningMapper = Mappers.getMapper(CleaningMapper.class);
        roomCleaningMapper = Mappers.getMapper(RoomCleaningMapper.class);
        
    }

    public List<CleaningDTO> getAllCleanings(){
        List<Cleaning> cleanings=cleaningRepository.getAllByOrderByTime();
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
}
