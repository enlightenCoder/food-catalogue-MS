package com.codedecode.foodCatalogue.mapper;

import com.codedecode.foodCatalogue.dto.FoodItemDTO;
import com.codedecode.foodCatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

    FoodItem mapFootItemDTOToFoodItem(FoodItemDTO foodItemDTO);

}
