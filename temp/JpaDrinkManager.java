/**
 * <p> Title: JpaDrinkManager.java </p>
 * <p> Description:   
 *
 * </p>
 * <p> 2008</p>
 * @author RHolland
 *
 *
 */ 

package com.baristamatic.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

 
import com.baristamatic.entity.Ingredient;
import com.baristamatic.exceptions.InventoryException;

//Required for Spring JpaDaoSupport transaction management
@Transactional
public class JpaDrinkManager extends JpaDaoSupport implements IDrinkManager {

	/* 
	 * @see com.baristamatic.dao.IDrinkManager#consumeIngredient(java.lang.String, int)
	 */
//	public Ingredient consumeIngredient(String name, int count) {
//
//		return null;
//	}
//
//	/* 
//	 * @see com.baristamatic.dao.IDrinkManager#createDrink(java.util.Map)
//	 */
//	public void createDrink(Map<String, Integer> ingredientMap) throws InventoryException {
//	}
//
//	/* 
//	 * @see com.baristamatic.dao.IDrinkManager#getAllDrinks()
//	 */
//	public List<Drink> getAllDrinks() {
//
//		return null;
//	}
//
//	/* 
//	 * @see com.baristamatic.dao.IDrinkManager#getDrink(java.lang.String)
//	 */
//	public Drink getDrink(String drinkName) {
//
//		return null;
//	}
//
//	/* 
//	 * @see com.baristamatic.dao.IDrinkManager#getDrink(java.lang.Integer)
//	 */
//	public Drink getDrink(Integer drinkNumber) {
//
//		return null;
//	}

	/* 
	 * @see com.baristamatic.dao.IDrinkManager#getIngredient(java.lang.String)
	 */
	public Ingredient getIngredient(String name) {
		List<Ingredient> ingredients  = getJpaTemplate().find("select t from Ingredient t where t.name = ?1", name);
		return ingredients.get(0);
	}

	/* 
	 * @see com.baristamatic.dao.IDrinkManager#addIngredient(com.baristamatic.entity.Ingredient)
	 */
	public void addIngredient(Ingredient ingredient) {
		System.out.println("addIngredient: called");
		getJpaTemplate().persist(ingredient);
	}

//	/* 
//	 * @see com.baristamatic.dao.IDrinkManager#getIngredientCount(java.lang.String)
//	 */
//	public int getIngredientCount(String name) {
//
//		return 0;
//	}
//
//	/* 
//	 * @see com.baristamatic.dao.IDrinkManager#getInventoryEntries()
//	 */
//	public List<InventoryEntry> getInventoryEntries() {
//
//		return null;
//	}
//
//	/* 
//	 * @see com.baristamatic.dao.IDrinkManager#hasIngredientCount(java.lang.String, int)
//	 */
//	public boolean hasIngredientCount(String name, int requiredCount) {
//
//		return false;
//	}
//
//	/* 
//	 * @see com.baristamatic.dao.IDrinkManager#hasIngredientCount(java.util.Map)
//	 */
//	public boolean hasIngredientCount(Map<String, Integer> ingredientMap) {
//
//		return false;
//	}

}
