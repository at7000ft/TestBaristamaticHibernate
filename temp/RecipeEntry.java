/**
 * <p> Title: RecipeEntry.java </p>
 * <p> Description:   
 *
 * </p>
 * <p> 2008</p>
 * @author RHolland
 *
 *
 */ 

package com.baristamatic.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RecipeEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer ingredientCount;
 
	/*
	 * ingredient_id is foreign key column generated in RecipeEntry table referencing Ingredient table row
	 * cascade saves ingredient when this class is saved
	 */
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="ingredient_id")
	private Ingredient ingredient;
	
//	@ManyToOne
//	@JoinColumn(name="recipe_id")
//	private Recipe recipe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIngredientCount() {
		return ingredientCount;
	}

	public void setIngredientCount(Integer ingredientCount) {
		this.ingredientCount = ingredientCount;
	}

 

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

//	public Recipe getRecipe() {
//		return recipe;
//	}
//
//	public void setRecipe(Recipe recipe) {
//		this.recipe = recipe;
//	}

}
