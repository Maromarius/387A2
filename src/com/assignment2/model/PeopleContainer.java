/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment2.model;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Philip
 */
public class PeopleContainer {
    
	private ArrayList<Integer> pIds;
    private HashMap<Integer,Person> peopleList;
    
    public PeopleContainer()
    {
    	pIds = new ArrayList<Integer>();
        peopleList = new HashMap<Integer,Person>();
    }
    
    public void AddPerson(Person p)
    {
    	if(verifyIntegrity(p.getpId())){
    		pIds.add(p.getpId());
            peopleList.put(p.getpId(), p);
    	}
    
    }
    
    public Person GetPerson(int pid)
    {
        return peopleList.get(pid);
    }
    
    public boolean RemovePerson(int pid)
    {
    	if(peopleList.containsKey(pid))
    	{
    		for(int i = 0; i < pIds.size(); i++)
    		{
    			if(pIds.get(i) == pid)
    			{
    				pIds.remove(i);
    			}
    		}
    		peopleList.remove(pid);
    		return true;
    	}
    	return false;
    }
    
    public void UpdatePerson(Person p)
    {
        peopleList.put(p.getpId(), p);
    }
    
    public ArrayList<Person> GetPersonList()
    {
    	ArrayList<Person> people = new ArrayList<Person>();
    	for(int i = 0; i < pIds.size();i++)
    	{
    		people.add(peopleList.get(pIds.get(i)));
    	}
    	return people;
    }
    
    public int GetSize()
    {
    	return this.peopleList.size();
    }
    
    public HashMap<Integer,Person> GetPersonMap()
    {
        return peopleList;
    }
    
    public boolean verifyIntegrity(int id)
	{
		
		if(!pIds.contains(id))
		{ 
			//pIds.add(id);
			return true;
		}	
		return false;
	}

}
