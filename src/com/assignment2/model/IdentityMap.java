package com.assignment2.model;

import java.util.HashMap;

public class IdentityMap 
{
	private HashMap<Integer, Person> people = new HashMap<Integer, Person>();
	
	public Person findPerson(int id)
	{	
		return people.get(id); // returns null if not found
	}
	
	public void addPerson(int id, Person p)
	{
		people.put(id, p);
	}
}
