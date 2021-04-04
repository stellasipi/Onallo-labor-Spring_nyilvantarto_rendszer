package hu.bme.vik.tbs.onlab.CsotthonApp.service;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.*;
import hu.bme.vik.tbs.onlab.CsotthonApp.mapper.CleaningMapper;
import hu.bme.vik.tbs.onlab.CsotthonApp.mapper.RoomCleaningMapper;
import hu.bme.vik.tbs.onlab.CsotthonApp.mapper.RoomMapper;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Cleaning;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Room;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.RoomCleaning;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.RoomCleaningItemPairing;
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
    private CleaningRepository cleaningRepository;

    @Autowired
    private RoomCleaningRepository roomCleaningRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ScoutGroupRepository scoutGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CleaningItemRepository cleaningItemRepository;

    @Autowired
    private RoomCleaningItemPairingRepository roomCleaningItemPairingRepository;

    @Autowired
    private final CleaningMapper cleaningMapper;

    @Autowired
    private final RoomCleaningMapper roomCleaningMapper;

    @Autowired
    private final RoomMapper roomMapper;

    public CleaningService() {
        cleaningMapper = Mappers.getMapper(CleaningMapper.class);
        roomCleaningMapper = Mappers.getMapper(RoomCleaningMapper.class);
        roomMapper = Mappers.getMapper(RoomMapper.class);

    }

    public List<CleaningDTO> getAllCleanings() {
        List<Cleaning> cleanings = cleaningRepository.getAllByOrderByTimeDesc();
        List<CleaningDTO> cleaningDTOs = new ArrayList<>();
        for (Cleaning cleaning : cleanings) {
            cleaningDTOs.add(cleaningMapper.cleaingToCleaningDTO(cleaning));
        }
        return cleaningDTOs;
    }

    public List<RoomCleaningDTO> getRoomCleaningsForCleanging(Integer cleaningId, String roomName) {
        List<RoomCleaning> roomCleanings = new ArrayList<>();
        Optional<Cleaning> cleaning = cleaningRepository.findById(cleaningId);
        if (cleaning.isPresent()) {
            if (roomName != null) {
                if (roomRepository.findByName(roomName) != null)
                    roomCleanings = roomCleaningRepository.findByCleaningAndRoomCleaningItemPairingRoomName(cleaning.get(), roomRepository.findByName(roomName).getName());
            } else {
                roomCleanings = roomCleaningRepository.findByCleaning(cleaning.get());
            }
        }
        return createRoomCleaningDTOs(roomCleanings);
    }

    private List<RoomCleaningDTO> createRoomCleaningDTOs(List<RoomCleaning> roomCleanings) {
        List<RoomCleaningDTO> roomCleaningDTOs = new ArrayList<>();
        for (RoomCleaning roomCleaning : roomCleanings) {
            RoomCleaningItemPairingDTO pairingDTO = new RoomCleaningItemPairingDTO(
                    roomCleaning.getRoomCleaningItemPairing().getId(),
                    roomCleaning.getRoomCleaningItemPairing().getRoom().getName(),
                    roomCleaning.getRoomCleaningItemPairing().getCleaningItem().getName()
            );

            RoomCleaningDTO roomCleaningDTO = roomCleaningMapper.roomCleaingToRoomCleaningDTO(roomCleaning);
            roomCleaningDTO.setRoomCleaningItemPairing(pairingDTO);

            roomCleaningDTOs.add(roomCleaningDTO);
        }
        return roomCleaningDTOs;
    }

    public List<RoomDTO> getRooms() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomDTO> roomDTOs = new ArrayList<>();
        for (Room room : rooms) {
            roomDTOs.add(roomMapper.roomToRoomDTO(room));
        }
        return roomDTOs;
    }

    public List<RoomCleaningItemPairingMapDTO> getPairings() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomCleaningItemPairing> pairings = roomCleaningItemPairingRepository.findAll();

        List<RoomCleaningItemPairingMapDTO> pairingMapDTOs = new ArrayList<>();

        for (Room room : rooms) {
            List<RoomCleaningItemPairing> pairingsByRoomName = roomCleaningItemPairingRepository.findByRoomName(room.getName());
            List<String> cleaningItems = new ArrayList<>();
            for (RoomCleaningItemPairing pairing : pairingsByRoomName) {
                cleaningItems.add(pairing.getCleaningItem().getName());
            }
            RoomCleaningItemPairingMapDTO mapDTO = new RoomCleaningItemPairingMapDTO(room.getName(), cleaningItems);
            pairingMapDTOs.add(mapDTO);
        }
        return pairingMapDTOs;
    }

    @Transactional
    public CleaningDTO createCleaning(List<RoomCleaningDTO> roomCleaningDTOs) {
        Cleaning cleaning = Cleaning.builder()
                .scoutGroup(scoutGroupRepository.findByName("Levendula")) //TODO ezt majd javítani
                .user(userRepository.findByEmail("stella@email.com")) //TODO ezt majd javítani
                .time(Time.getNowInUTC())
                .build();
        cleaningRepository.save(cleaning);

        List<RoomCleaningDTO> persisRoomCleaningDTOs = new ArrayList<>();

        for (RoomCleaningDTO roomCleaningDTO : roomCleaningDTOs) {
            RoomCleaning roomCleaning = roomCleaningMapper.roomCleaningDTOtoRoomCleaning(roomCleaningDTO);
            RoomCleaningItemPairing pairing = roomCleaningItemPairingRepository.findByRoomNameAndCleaningItemName(roomCleaningDTO.getRoomCleaningItemPairing().getRoomName(), roomCleaningDTO.getRoomCleaningItemPairing().getCleaningItemName());
            roomCleaning.setRoomCleaningItemPairing(pairing);
            roomCleaning.setCleaning(cleaning);

            roomCleaningRepository.save(roomCleaning);

            persisRoomCleaningDTOs.add(roomCleaningMapper.roomCleaingToRoomCleaningDTO(roomCleaning));
        }
        return cleaningMapper.cleaingToCleaningDTO(cleaning);
    }

    @Transactional
    public Boolean deleteCleaning(Integer cleaningId) {
        Optional<Cleaning> cleaningOptional = cleaningRepository.findById(cleaningId);
        if (cleaningOptional.isPresent()) {
            cleaningRepository.delete(cleaningOptional.get());
            return true;
        } else {
            return false;
        }
    }

}