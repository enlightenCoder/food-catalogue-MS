package com.codedecode.foodCatalogue.dto;

import com.codedecode.foodCatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCatalogPage {

    List<FoodItem> foodItemList = new ArrayList<>();

    RestaurantDTO restaurantDTO;
}
