package com.assignment2.model;

import java.util.ArrayList;


public class  IdentityMap {

	private ArrayList personId = new ArrayList();
	
	public boolean verifyIntegrity(int id)
	{
		
		if(!personId.contains(id))
		{ 
			personId.add(id);
			return true;
		}	
		return false;
	}
	
}
