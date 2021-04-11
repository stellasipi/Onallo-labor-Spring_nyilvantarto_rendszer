package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.LogDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.Log;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogMapper {
    LogDTO logToLogDTO(Log log);
    Log logDTOtoLog(LogDTO logDTO);
}
