package hu.bme.vik.tbs.onlab.CsotthonApp.mapper;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.MaintenanceDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Maintenance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper {
    MaintenanceDTO maintenanceToMaintenanceDTO(Maintenance maintenance);
    Maintenance maintenanceDTOtoMaintenance(MaintenanceDTO maintenanceDTO);
}
