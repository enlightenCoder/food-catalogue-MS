package com.codedecode.foodCatalogue.service;


import com.codedecode.foodCatalogue.dto.FoodCatalogPage;
import com.codedecode.foodCatalogue.dto.FoodItemDTO;
import com.codedecode.foodCatalogue.dto.RestaurantDTO;
import com.codedecode.foodCatalogue.entity.FoodItem;
import com.codedecode.foodCatalogue.mapper.FoodItemMapper;
import com.codedecode.foodCatalogue.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private WebClient webClient;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {

        FoodItem foodItemSaved = foodItemRepository.save(FoodItemMapper.INSTANCE.mapFootItemDTOToFoodItem(foodItemDTO));

        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSaved);
    }


    public FoodCatalogPage fetchFoodCataloguePageDetails(Integer restaurantId) {

        List<FoodItem> foodItemList = fetchFoodItemDetails(restaurantId);

        RestaurantDTO restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);

        return createFoodCataloguePage(foodItemList, restaurant);

    }

    private FoodCatalogPage createFoodCataloguePage(List<FoodItem> foodItemList, RestaurantDTO restaurant) {
        return new FoodCatalogPage(foodItemList, restaurant);
    }

    private RestaurantDTO fetchRestaurantDetailsFromRestaurantMS(Integer id) {

        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(RestaurantDTO.class)
                .block();
    }

    private List<FoodItem> fetchFoodItemDetails(Integer restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}
