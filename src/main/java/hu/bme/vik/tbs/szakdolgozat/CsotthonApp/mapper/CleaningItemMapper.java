package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.CleaningItemDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.CleaningItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CleaningItemMapper {
    CleaningItemDTO cleaningItemtoCleaningItemDTO(CleaningItem cleaningItem);
    CleaningItem cleaningItemDTOtoCleaningItem(CleaningItemDTO cleaningItemDTO);
}
