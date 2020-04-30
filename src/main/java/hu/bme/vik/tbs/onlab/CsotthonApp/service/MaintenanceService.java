package hu.bme.vik.tbs.onlab.CsotthonApp.service;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.MaintenanceDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.mapper.MaintenanceMapper;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Maintenance;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.User;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.MaintenanceRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceService {
    @Autowired
    MaintenanceRepository maintenanceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private final MaintenanceMapper maintenanceMapper;

    public MaintenanceService(){ maintenanceMapper = Mappers.getMapper(MaintenanceMapper.class);}

    public MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO){
        Maintenance maintenance=maintenanceMapper.maintenanceDTOtoMaintenance(maintenanceDTO);
        maintenance.setId(null);
        maintenance.setTime(new Timestamp(System.currentTimeMillis()));
        //majd a user setelése
        User user=userRepository.findById(maintenance.getUser().getId()).get();
        maintenance.setUser(user);
        maintenanceRepository.save(maintenance);
        return maintenanceMapper.maintenanceToMaintenanceDTO(maintenance);
    }

    public List<MaintenanceDTO> getAll(){
        List<Maintenance> maintenances=maintenanceRepository.findAllByOrderByTimeDesc();
        List<MaintenanceDTO> maintenanceDTOs=new ArrayList<>();
        for(Maintenance maintenance:maintenances){
            maintenanceDTOs.add(maintenanceMapper.maintenanceToMaintenanceDTO(maintenance));
        }
        return maintenanceDTOs;
    }
    public Boolean delete(Integer id){
        maintenanceRepository.deleteById(id);
        if(maintenanceRepository.findById(id).isPresent()){
            return false;
        }else {
            return true;
        }
    }
}
