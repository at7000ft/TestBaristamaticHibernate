package com.baristamatic.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.baristamatic.exceptions.InventoryException;

/**
 * <p>
 * Title: Drink.java
 * </p>
 * <p>
 * Description: Entity representing a drink including it's ingredientMap recipe, name and number.
 * 
 * </p>
 * <p>
 * 2008
 * </p>
 * 
 * @author RHolland
 */
@Entity
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer drinkNumber;

	protected String name;

	protected String displayName;

	/**
	 * The @OneToMany annotation has a few important attributes that need to be included. First of all, you need to 
	 * have the mappedBy attribute. And what is the mappedBy attribute? Well, this actually maps to the variable 
	 * name the encapsulating class(Team) takes in the encapsulated entity Player). So, if you looked at the Player 
	 * class, you'd see that there is an instance variable of type Team named team, in all lower case letters. This 
	 * variable named team maps the Player back to their Team, and as such, becomes the value of the mappedBy attribute.
	 * 
	 * Along with the mappedBy attribute, the @OneToMany annotations needs a targetEntity attribute. Since any 
	 * generic Object can be placed into a List, Vector, or other collection class that implements the many part of 
	 * the association, it is important to explicitly state in the annotation what type of object class will be contained 
	 * in the collection. This should be done even when the contained object type is defined using generics syntax. 
	 * Since our team contains players, Player.class is the value of the targetEntity attribute of the Team's @OneToMany 
	 * annotation.
	 * 
	 * If you want changes to the owning entity to cascade to the owned entity when a change occurs, you should set 
	 * your CascadeType to ALL. Other available options for the CascadeType include: MERGE, PERSIST, REFRESH and REMOVE.
	 */
	 //@OneToMany(mappedBy="recipe", targetEntity=RecipeEntry.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	
	/*
	 * cascade saves all RecipeEntrys when this class is saved
	 * drink_id is generated column in RecipeEntry table referencing drinkNumber primary key in the Drink table
	 */
	 @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	 @JoinColumn(name = "drinkNumber")
	private List<RecipeEntry> entryList = new ArrayList<RecipeEntry>();


	/**
	 * Creates the drink.
	 * 
	 * @throws InventoryException the inventory exception
	 */
	public void createDrink() throws InventoryException {
		// inventoryManager.createDrink(ingredientMap);
	}

	/**
	 * Gets the cost.
	 * 
	 * @return the cost
	 */
	public BigDecimal getCost() {
		BigDecimal totalCost = new BigDecimal(0);
		// for (Map.Entry<String, Integer> ent : ingredientMap.entrySet()) {
		// int count = ent.getValue();
		// Ingredient ingredient = inventoryManager.getIngredient(ent.getKey());
		// BigDecimal ingredientCost = ingredient.getUnitCost().multiply(new BigDecimal(count));
		// totalCost = totalCost.add(ingredientCost);
		// }
		return totalCost;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// return drinkNumber.toString() + "," + displayName + ",$" + getCost() + ","
		// + inventoryManager.hasIngredientCount(ingredientMap);
		return "";
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the display name.
	 * 
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 * 
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Gets the drink number.
	 * 
	 * @return the drink number
	 */
	public Integer getDrinkNumber() {
		return drinkNumber;
	}

	/**
	 * Sets the drink number.
	 * 
	 * @param drinkNumber the new drink number
	 */
	public void setDrinkNumber(Integer drinkNumber) {
		this.drinkNumber = drinkNumber;
	}

	public List<RecipeEntry> getEntryList() {
		return entryList;
	}

	public void setEntryList(List<RecipeEntry> entryList) {
		this.entryList = entryList;
	}



}
