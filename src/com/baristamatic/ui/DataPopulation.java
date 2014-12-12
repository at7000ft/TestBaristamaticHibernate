package com.baristamatic.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.baristamatic.entity.Drink;
import com.baristamatic.entity.Ingredient;
import com.baristamatic.entity.InventoryEntry;
import com.baristamatic.entity.RecipeEntry;


public class DataPopulation {
	private static Integer defaultInventoryCount = 10;
	
	public static void cleanTables(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//All RecipeEntrys are delete when Drink is deleted
		Query q = em.createQuery ("select x from Drink x");
		List<Drink> dresults = q.getResultList ();
		for (Drink drink : dresults) {
			em.remove(drink);
		}
		
		q = em.createQuery ("select x from InventoryEntry x");
		List<InventoryEntry> ivresults = q.getResultList ();
		for (InventoryEntry entry : ivresults) {
			em.remove(entry);
		}
		
		q = em.createQuery ("select x from Ingredient x");
		List<Ingredient> iresults = q.getResultList ();
		for (Ingredient ingredient : iresults) {
			em.remove(ingredient);
		}

		tx.commit();
		em.close();
	}
	
	public static void populate(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// Populate Ingredients
		Ingredient coffeeIngredient = new Ingredient();
		coffeeIngredient.setName("coffee");
		coffeeIngredient.setUnitCost(new BigDecimal(.75));
		em.persist(coffeeIngredient);
		
		Ingredient sugarIngredient = new Ingredient();
		sugarIngredient.setName("sugar");
		sugarIngredient.setUnitCost(new BigDecimal(.25));
		em.persist(sugarIngredient);
		
		Ingredient creamIngredient = new Ingredient();
		creamIngredient.setName("cream");
		creamIngredient.setUnitCost(new BigDecimal(.25));
		em.persist(creamIngredient);
		
		Ingredient decafIngredient = new Ingredient();
		decafIngredient.setName("decafCoffee");
		decafIngredient.setUnitCost(new BigDecimal(.75));
		em.persist(decafIngredient);
		
		Ingredient steamedMilkIngredient = new Ingredient();
		steamedMilkIngredient.setName("steamedMilk");
		steamedMilkIngredient.setUnitCost(new BigDecimal(.35));
		em.persist(steamedMilkIngredient);
		
		Ingredient foamedMilkIngredient = new Ingredient();
		foamedMilkIngredient.setName("foamedMilk");
		foamedMilkIngredient.setUnitCost(new BigDecimal(.35));
		em.persist(foamedMilkIngredient);
		
		Ingredient espressoIngredient = new Ingredient();
		espressoIngredient.setName("espresso");
		espressoIngredient.setUnitCost(new BigDecimal(1.10));
		em.persist(espressoIngredient);
		
		Ingredient cocoaIngredient = new Ingredient();
		cocoaIngredient.setName("cocoa");
		cocoaIngredient.setUnitCost(new BigDecimal(.90));
		em.persist(cocoaIngredient);
		
		Ingredient whippedCreamIngredient = new Ingredient();
		whippedCreamIngredient.setName("whippedCream");
		whippedCreamIngredient.setUnitCost(new BigDecimal(1.00));
		em.persist(whippedCreamIngredient);
		
		// Populate Ingredient Inventory
		InventoryEntry invEntry = new InventoryEntry();
		invEntry.setDisplayName("Coffee");
		invEntry.setIngredient(coffeeIngredient);
		invEntry.setIngredientCount(defaultInventoryCount);
		invEntry.setName(coffeeIngredient.getName());
		em.persist(invEntry);
		
		invEntry = new InventoryEntry();
		invEntry.setDisplayName("Sugar");
		invEntry.setIngredient(sugarIngredient);
		invEntry.setIngredientCount(defaultInventoryCount);
		invEntry.setName(sugarIngredient.getName());
		em.persist(invEntry);
		
		invEntry = new InventoryEntry();
		invEntry.setDisplayName("Cream");
		invEntry.setIngredient(creamIngredient);
		invEntry.setIngredientCount(defaultInventoryCount);
		invEntry.setName(creamIngredient.getName());
		em.persist(invEntry);
		
		invEntry = new InventoryEntry();
		invEntry.setDisplayName("SteamedMilk");
		invEntry.setIngredient(steamedMilkIngredient);
		invEntry.setIngredientCount(defaultInventoryCount);
		invEntry.setName(steamedMilkIngredient.getName());
		em.persist(invEntry);
		
		invEntry = new InventoryEntry();
		invEntry.setDisplayName("FoamedMilk");
		invEntry.setIngredient(foamedMilkIngredient);
		invEntry.setIngredientCount(defaultInventoryCount);
		invEntry.setName(foamedMilkIngredient.getName());
		em.persist(invEntry);
		
		invEntry = new InventoryEntry();
		invEntry.setDisplayName("Espresso");
		invEntry.setIngredient(espressoIngredient);
		invEntry.setIngredientCount(defaultInventoryCount);
		invEntry.setName(espressoIngredient.getName());
		em.persist(invEntry);
		
		invEntry = new InventoryEntry();
		invEntry.setDisplayName("Cocoa");
		invEntry.setIngredient(cocoaIngredient);
		invEntry.setIngredientCount(defaultInventoryCount);
		invEntry.setName(cocoaIngredient.getName());
		em.persist(invEntry);
		
		invEntry = new InventoryEntry();
		invEntry.setDisplayName("WhippedCream");
		invEntry.setIngredient(whippedCreamIngredient);
		invEntry.setIngredientCount(defaultInventoryCount);
		invEntry.setName(cocoaIngredient.getName());
		em.persist(invEntry);
		
		// Populate Coffee Drink
		Drink drink = new Drink();
		drink.setDrinkNumber(1);
		drink.setDisplayName("Coffee");
		drink.setName("coffee");
		RecipeEntry coffeeEntry = new RecipeEntry();
		coffeeEntry.setIngredientCount(3);
		coffeeEntry.setIngredient(coffeeIngredient);
		coffeeEntry.setDrink(drink);
		
		RecipeEntry sugarEntry = new RecipeEntry();
		sugarEntry.setIngredientCount(1);
		sugarEntry.setIngredient(sugarIngredient);
		sugarEntry.setDrink(drink);
		
		RecipeEntry creamEntry = new RecipeEntry();
		creamEntry.setIngredientCount(1);
		creamEntry.setIngredient(creamIngredient);
		creamEntry.setDrink(drink);
		
		List<RecipeEntry> entryList = new ArrayList<RecipeEntry>();
		entryList.add(coffeeEntry);
		entryList.add(sugarEntry);
		entryList.add(creamEntry);
		drink.setEntryList(entryList);

		
		em.persist(drink);
		tx.commit();
		em.close();
	}
}
