/**
 * <p> Title: TestMain.java </p>
 * <p> Description:   
 *
 * </p>
 * <p> 2008</p>
 * @author RHolland
 *
 *
 */ 

package com.baristamatic.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.baristamatic.dao.IDrinkManager;
import com.baristamatic.entity.Drink;

public class TestMain {
	private static ApplicationContext context;
	private static IDrinkManager drinkManager;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Suppress Spring log messages on console
		DOMConfigurator.configure("config/log4j.xml");
		

		// Spring configure a IInventoryManagerDao and IDrinkManager
		context = new FileSystemXmlApplicationContext("config/applicationContext.xml");
		drinkManager = (IDrinkManager) context.getBean("drinkManager");
		List<Drink> drinks = null;
		try {
			drinks = drinkManager.getAllDrinks();
		} catch (Exception e) {
			System.err.println("ERROR - " + e);
			return;
		}
		System.out.println("main: drink count - " + drinks.size());
		for (Drink drink : drinks) {
			System.out.println("main: drink - " + drink.detailToString());
		}
		
		//
		System.out.println("main: Drink 1 - " + drinkManager.getDrink(new Integer(1)).detailToString());
		
		//
		System.out.println("main: getInventoryEntries - " + drinkManager.getInventoryEntries().size());
		
		//
		System.out.println("main: getInventoryEntry (coffee) - " + drinkManager.getInventoryEntry("coffee"));
		
		//
		
		System.out.println("main: decrementInventoryEntry (coffee) - " + drinkManager.decrementInventoryEntry("coffee", 3));
		
		//
		Drink drink = drinkManager.getDrink(new Integer(1));
		System.out.println("main: hasIngredientCount (1) - " + drinkManager.hasIngredientCount(drink));
		
		//
 
		System.out.println("main: adjustInventory (1) called ");
		drinkManager.adjustInventory(drink);
	}
	
 

}
