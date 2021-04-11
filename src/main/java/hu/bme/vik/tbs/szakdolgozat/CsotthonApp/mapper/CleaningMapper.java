package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.CleaningDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.Cleaning;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CleaningMapper {
    CleaningDTO cleaingToCleaningDTO(Cleaning cleaning);
    Cleaning cleaningDTOtoCleaing(CleaningDTO cleaningDTO);
}
