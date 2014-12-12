package com.baristamatic.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.baristamatic.entity.Drink;
import com.baristamatic.entity.Ingredient;
import com.baristamatic.entity.InventoryEntry;
import com.baristamatic.entity.RecipeEntry;
import com.baristamatic.exceptions.InventoryException;

/**
 * <p>
 * Title: Interface IDrinkManager.
 * </p>
 * 
 * <p>
 * Description: Abstract Drink management from implementation
 * 
 * </p>
 * <p>
 * 2008
 * </p>
 * 
 * @author RHolland
 */
public interface IDrinkManager {
	public List<Drink> getAllDrinks();

	public Drink getDrink(Integer drinkNumber);

	public InventoryEntry getInventoryEntry(String name);

	public InventoryEntry decrementInventoryEntry(String name, int decrementCount);

	public List<InventoryEntry> getInventoryEntries();
}
