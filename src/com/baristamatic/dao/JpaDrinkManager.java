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

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.baristamatic.entity.Drink;
import com.baristamatic.entity.InventoryEntry;


/**
 * The JpaTemplate will ensure that EntityManagers are properly opened and closed and automatically 
 * participate in transactions. Moreover, the JpaTemplate properly handles exceptions, making sure resources 
 * are cleaned up and the appropriate transactions rolled back. The template instances are thread-safe and 
 * reusable and they can be kept as instance variable of the enclosing class. Note that JpaTemplate offers 
 * single-step actions such as find, load, merge, etc along with alternative convenience methods that can 
 * replace one line callback implementations.
 * 
 * @Transactional is required for Spring JpaDaoSupport transaction management
 */
@Transactional
public class JpaDrinkManager extends JpaDaoSupport implements IDrinkManager {
	
	/** The log. */
	private static Logger log = Logger.getLogger(JpaDrinkManager.class);

	/* 
	 * @see com.baristamatic.dao.IDrinkManager#getAllDrinks()
	 */
	public List<Drink> getAllDrinks() {
		List<Drink> drinks  = getJpaTemplate().find("select d from Drink d");
		//log.debug("getAllDrinks: returning " + drinks.size());
		return drinks;
	}

	/* 
	 * @see com.baristamatic.dao.IDrinkManager#getInventoryEntries()
	 */
	public List<InventoryEntry> getInventoryEntries() {
		List<InventoryEntry> entries  = getJpaTemplate().find("select d from InventoryEntry d");
		//log.debug("getInventoryEntries: returning " + entries.size());
		return entries;
	}

	/* (non-Javadoc)
	 * @see com.baristamatic.dao.IDrinkManager#getInventoryEntry(java.lang.String)
	 */
	public InventoryEntry getInventoryEntry(String name) {
		List<InventoryEntry> entries  = getJpaTemplate().find("select d from InventoryEntry d where d.name = ?1", name);
		//log.debug("getInventoryEntry: found " + entries.size());
		InventoryEntry entry = entries.get(0);
		return entry;
	}

	/* (non-Javadoc)
	 * @see com.baristamatic.dao.IDrinkManager#decrementInventoryEntry(java.lang.String, int)
	 */
	public InventoryEntry decrementInventoryEntry(String name, int decrementCount) {
		List<InventoryEntry> entries  = getJpaTemplate().find("select d from InventoryEntry d where d.name = ?1", name);
		//log.debug("decrementInventoryEntry: found " + entries.size());
		InventoryEntry entry = entries.get(0);
		int currentCount = entry.getIngredientCount();
		int newCount = currentCount - decrementCount;
		entry.setIngredientCount(newCount);
		return getJpaTemplate().merge(entry);
	}

	/* (non-Javadoc)
	 * @see com.baristamatic.dao.IDrinkManager#getDrink(java.lang.Integer)
	 */
	public Drink getDrink(Integer drinkNumber) {
		return getJpaTemplate().find(Drink.class, drinkNumber);
	}

}
