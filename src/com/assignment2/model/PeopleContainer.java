/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment2.model;
import java.util.HashMap;
import java.util.Map;
import com.assignment2.controller.*;


/**
 *
 * @author Philip
 */
public class PeopleContainer {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private Map<Integer,Person> peopleList;
    
    public PeopleContainer()
    {
        peopleList = new HashMap<Integer,Person>() {};
    }
    
    public void AddPerson(Person p)
    {
        peopleList.put(p.getpId(), p);
    }
    
    public Person GetPerson(int pid)
    {
        return peopleList.get(pid);
    }
    
    public boolean RemovePerson(int pid)
    {
    	if(peopleList.containsKey(pid))
    	{
    		peopleList.remove(pid);
        	return true;
    	}
    	return false;
    }
    
    public void UpdatePerson(int pid, Person newPerson)
    {
        peopleList.remove(pid);
        
        peopleList.put(pid, newPerson);
    }
    
    public Map<Integer,Person> GetContainer()
    {
        return peopleList;
    }

}
