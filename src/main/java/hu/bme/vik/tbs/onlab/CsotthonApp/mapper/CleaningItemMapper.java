package hu.bme.vik.tbs.onlab.CsotthonApp.mapper;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.CleaningItemDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.CleaningItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CleaningItemMapper {
    CleaningItemDTO cleaningItemtoCleaningItemDTO(CleaningItem cleaningItem);
    CleaningItem cleaningItemDTOtoCleaningItem(CleaningItemDTO cleaningItemDTO);
}
