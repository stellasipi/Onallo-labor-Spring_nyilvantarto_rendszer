package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.MaintenanceDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.Maintenance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper {
    MaintenanceDTO maintenanceToMaintenanceDTO(Maintenance maintenance);
    Maintenance maintenanceDTOtoMaintenance(MaintenanceDTO maintenanceDTO);
}
