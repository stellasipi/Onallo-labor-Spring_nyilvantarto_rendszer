package hu.bme.vik.tbs.onlab.CsotthonApp.mapper;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.CleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Cleaning;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CleaningMapper {
    CleaningDTO cleaingToCleaningDTO(Cleaning cleaning);
    Cleaning cleaningDTOtoCleaing(CleaningDTO cleaningDTO);
}
