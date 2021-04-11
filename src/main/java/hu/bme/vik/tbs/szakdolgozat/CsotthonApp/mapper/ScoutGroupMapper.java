package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.ScoutGroupDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.ScoutGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoutGroupMapper {
    ScoutGroupDTO scoutGroupToScoutGroupDTO(ScoutGroup scoutGroup);
    ScoutGroup scoutGroupDTOtoScoutGroup(ScoutGroupDTO scoutGroupDTO);
}
