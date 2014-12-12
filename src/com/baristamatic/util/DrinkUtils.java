package com.baristamatic.util;

import java.util.List;

import com.baristamatic.dao.IDrinkManager;
import com.baristamatic.entity.Drink;
import com.baristamatic.entity.Ingredient;
import com.baristamatic.entity.InventoryEntry;
import com.baristamatic.entity.RecipeEntry;

public class DrinkUtils {
	public static boolean hasIngredientCount(IDrinkManager drinkManager, List<RecipeEntry> entries) {
	
		for (RecipeEntry recipeEntry : entries) {
			Ingredient ingredient = recipeEntry.getIngredient();
			int requiredCount = recipeEntry.getIngredientCount();
			InventoryEntry entry = drinkManager.getInventoryEntry(ingredient.getName());
			int availableCount = entry.getIngredientCount();
			if (availableCount < requiredCount) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void adjustInventory(IDrinkManager drinkManager,Drink drink) {
		List<RecipeEntry> entries = drink.getEntryList();
		for (RecipeEntry recipeEntry : entries) {
			int decrementCount = recipeEntry.getIngredientCount();
			String name = recipeEntry.getIngredient().getName();
			drinkManager.decrementInventoryEntry(name, decrementCount);
		}
	}
}
