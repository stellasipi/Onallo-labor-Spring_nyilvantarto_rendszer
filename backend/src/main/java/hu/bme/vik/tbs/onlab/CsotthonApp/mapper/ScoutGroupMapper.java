package hu.bme.vik.tbs.onlab.CsotthonApp.mapper;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.ScoutGroupDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.ScoutGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoutGroupMapper {
    ScoutGroupDTO scoutGroupToScoutGroupDTO(ScoutGroup scoutGroup);
    ScoutGroup scoutGroupDTOtoScoutGroup(ScoutGroupDTO scoutGroupDTO);
}
