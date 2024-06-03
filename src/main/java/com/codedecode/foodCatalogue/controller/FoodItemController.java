package com.codedecode.foodCatalogue.controller;


import com.codedecode.foodCatalogue.dto.FoodCatalogPage;
import com.codedecode.foodCatalogue.dto.FoodItemDTO;
import com.codedecode.foodCatalogue.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;


    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {

        FoodItemDTO foodItemSaved =foodItemService.addFoodItem(foodItemDTO);

        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItems/{restaurantId}")
    public ResponseEntity<FoodCatalogPage> fetchRestauAndFoodDetails(@PathVariable Integer restaurantId) {

         FoodCatalogPage foodCatalogPage = foodItemService.fetchFoodCataloguePageDetails(restaurantId);

         return ResponseEntity.ok(foodCatalogPage);
    }

}
