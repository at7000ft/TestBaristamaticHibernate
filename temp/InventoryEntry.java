package com.baristamatic.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * <p>
 * Title: InventoryEntry.java
 * </p>
 * <p>
 * Description: Entity container for Inventory Ingredients, maintains unit counts.
 * 
 * </p>
 * <p>
 * 2008
 * </p>
 * 
 * @author RHolland
 */
@Entity
public class InventoryEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	private String displayName;
	private String name;
	
	@OneToOne 
	@JoinColumn(name="ingredient_id")
	private Ingredient ingredient;
	
	private Integer ingredientCount;

	/**
	 * Instantiates a new inventory entry.
	 */
	public InventoryEntry() {
		super();
	}

	 
 

	/**
	 * Consume ingredient.
	 * 
	 * @param name the name
	 * @param consumeCount the consume count
	 * 
	 * @return the ingredient
	 */
	public Ingredient consumeIngredient(String name, int consumeCount) {
		if (ingredientCount > 0) {
			ingredientCount = ingredientCount - consumeCount;
			return ingredient;
		}
		return null;
	}

	public Integer getIngredientCount() {
		return ingredientCount;
	}




	public void setIngredientCount(Integer ingredientCount) {
		this.ingredientCount = ingredientCount;
	}




	/**
	 * Checks for ingredient count.
	 * 
	 * @param requiredCount the required count
	 * 
	 * @return true, if successful
	 */
	public boolean hasIngredientCount(int requiredCount) {
		return (ingredientCount >= requiredCount);
	}

	/**
	 * Current inventory count.
	 * 
	 * @return the int
	 */
	public int currentInventoryCount() {
		return ingredientCount;
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
	 * Sets the ingredient.
	 * 
	 * @param ingredient the new ingredient
	 */
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	/**
	 * Gets the ingredient.
	 * 
	 * @return the ingredient
	 */
	public Ingredient getIngredient() {
		return ingredient;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return displayName + "," + ingredientCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
