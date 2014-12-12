/**
 * <p> Title: Recipe.java </p>
 * <p> Description:   
 *
 * </p>
 * <p> 2008</p>
 * @author RHolland
 *
 *
 */ 

package com.baristamatic.entity;

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

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
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
	 */
	 @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	 @JoinColumn(name = "recipe_id")
	private List<RecipeEntry> entryList = new ArrayList<RecipeEntry>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<RecipeEntry> getEntryList() {
		return entryList;
	}

	public void setEntryList(List<RecipeEntry> entryList) {
		this.entryList = entryList;
	}

}
