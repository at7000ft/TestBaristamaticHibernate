package com.baristamatic.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

 
 
import com.baristamatic.entity.Ingredient;
import com.baristamatic.exceptions.InventoryException;

/**
 * <p>Title: Interface IDrinkManager. </p>
 * 
 * <p> Description: Abstract Drink management from implementation
 * 
 * </p>
 * <p> 2008</p>
 * 
 * @author RHolland
 */
public interface IDrinkManager {
	
 
//	public List<Drink> getAllDrinks();
//	
// 
//	public Drink getDrink(String drinkName);
//	
// 
//	public Drink getDrink(Integer drinkNumber);
	
 
	public Ingredient getIngredient(String name);
	
	public void addIngredient(Ingredient ingredient);
	
 
//	public Ingredient consumeIngredient(String name, int count);
//	
//	 
//	public void createDrink(Map<String, Integer> ingredientMap) throws InventoryException;
//	
// 
//	public boolean hasIngredientCount(String name, int requiredCount);
//	
//	 
//	public boolean hasIngredientCount(Map<String, Integer> ingredientMap);
//	
// 
//	public int getIngredientCount(String name);
//	
// 
//	public List<InventoryEntry> getInventoryEntries();

}
