package hu.bme.vik.tbs.onlab.CsotthonApp.mapper;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.LogDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Log;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogMapper {
    LogDTO logToLogDTO(Log log);
    Log logDTOtoLog(LogDTO logDTO);
}
